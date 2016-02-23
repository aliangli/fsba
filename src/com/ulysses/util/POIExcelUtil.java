package com.ulysses.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIExcelUtil {

	/** 总行数 */
    private int totalRows = 0;
    
    /** 总列数 */
    private int totalCells = 0;

	private int sheetAt = 0;  //excel内的选项卡页
    
    /** 构造方法 */
    public POIExcelUtil()
    {}
    
    /**
     * <ul>
     * <li>Description:[根据文件名读取excel文件]</li>
     * <li>Created by [Huyvanpull] [Jan 20, 2010]</li>
     * <li>Midified by [modifier] [modified time]</li>
     * <ul>
     * 
     * @param fileName
     * @return
     * @throws Exception
     */
    public List<ArrayList<String>> read(String fileName)
    {
        List<ArrayList<String>> dataLst = new ArrayList<ArrayList<String>>();
        
        /** 检查文件名是否为空或者是否是Excel格式的文件 */
        if (fileName == null || !fileName.matches("^.+\\.(?i)((xls)|(xlsx))$"))
        {
            return dataLst;
        }
        
        boolean isExcel2003 = true;
        /** 对文件的合法性进行验证 */
        if (fileName.matches("^.+\\.(?i)(xlsx)$"))
        {
            isExcel2003 = false;
        }
        
        /** 检查文件是否存在 */
        File file = new File(fileName);
        if (file == null || !file.exists())
        {
            return dataLst;
        }
        
        try
        {
            /** 调用本类提供的根据流读取的方法 */
            dataLst = read(new FileInputStream(file), isExcel2003);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        /** 返回最后读取的结果 */
        return dataLst;
    }
    
    /**
     * <ul>
     * <li>Description:[根据流读取Excel文件]</li>
     * <li>Created by [Huyvanpull] [Jan 20, 2010]</li>
     * <li>Midified by [modifier] [modified time]</li>
     * <ul>
     * 
     * @param inputStream
     * @param isExcel2003
     * @return
     */
    public List<ArrayList<String>> read(InputStream inputStream,
            boolean isExcel2003)
    {
        List<ArrayList<String>> dataLst = null;
        try
        {
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = isExcel2003 ? new HSSFWorkbook(inputStream)
                    : new XSSFWorkbook(inputStream);
            dataLst = read(wb);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return dataLst;
    }
    
    /**
     * <ul>
     * <li>Description:[得到总行数]</li>
     * <li>Created by [Huyvanpull] [Jan 20, 2010]</li>
     * <li>Midified by [modifier] [modified time]</li>
     * <ul>
     * 
     * @return
     */
    public int getTotalRows()
    {
        return totalRows;
    }
    
    /**
     * <ul>
     * <li>Description:[得到总列数]</li>
     * <li>Created by [Huyvanpull] [Jan 20, 2010]</li>
     * <li>Midified by [modifier] [modified time]</li>
     * <ul>
     * 
     * @return
     */
    public int getTotalCells()
    {
        return totalCells;
    }
    
    /**
     * <ul>
     * <li>Description:[读取数据]</li>
     * <li>Created by [Huyvanpull] [Jan 20, 2010]</li>
     * <li>Midified by [modifier] [modified time]</li>
     * <ul>
     * 
     * @param wb
     * @return
     */
    private List<ArrayList<String>> read(Workbook wb)
    {
        List<ArrayList<String>> dataLst = new ArrayList<ArrayList<String>>();
        
        /** 得到第一个shell */
        Sheet sheet = wb.getSheetAt(sheetAt );
        this.totalRows = sheet.getPhysicalNumberOfRows();
        if (this.totalRows >= 1 && sheet.getRow(0) != null)
        {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        
        /** 循环Excel的行 */
        for (int r = 0; r < this.totalRows; r++)
        {
            Row row = sheet.getRow(r);
            if (row == null)
            {
                continue;
            }
            
            ArrayList<String> rowLst = new ArrayList<String>();
            /** 循环Excel的列 */
            for (short c = 0; c < this.getTotalCells(); c++)
            {
                Cell cell = row.getCell(c);
                String cellValue = "";
                if (cell == null)
                {
                    rowLst.add(cellValue);
                    continue;
                }
                
                /** 处理数字型的,自动去零 */
                if (Cell.CELL_TYPE_NUMERIC == cell.getCellType())
                {
                    /** 在excel里,日期也是数字,在此要进行判断 */
                    if (HSSFDateUtil.isCellDateFormatted(cell))
                    {
                        cellValue = UtilDateModel.get4yMdHms(cell.getDateCellValue());
                    }
                    else
                    {
                        cellValue = getRightStr(cell.getNumericCellValue() + "");
                    }
                }
                /** 处理字符串型 */
                else if (Cell.CELL_TYPE_STRING == cell.getCellType())
                {
                    cellValue = cell.getStringCellValue();
                }
                /** 处理布尔型 */
                else if (Cell.CELL_TYPE_BOOLEAN == cell.getCellType())
                {
                    cellValue = cell.getBooleanCellValue() + "";
                }
                /** 其它的,非以上几种数据类型 */
                else
                {
                    cellValue = cell.toString() + "";
                }
                
                rowLst.add(cellValue);
            }
            dataLst.add(rowLst);
        }
        return dataLst;
    }
    
    /**
     * <ul>
     * <li>Description:[正确地处理整数后自动加零的情况]</li>
     * <li>Created by [Huyvanpull] [Jan 20, 2010]</li>
     * <li>Midified by [modifier] [modified time]</li>
     * <ul>
     * 
     * @param sNum
     * @return
     */
    private String getRightStr(String sNum)
    {
        DecimalFormat decimalFormat = new DecimalFormat("#.000000");
        String resultStr = decimalFormat.format(new Double(sNum));
        if (resultStr.matches("^[-+]?\\d+\\.[0]+$"))
        {
            resultStr = resultStr.substring(0, resultStr.indexOf("."));
        }
        return resultStr;
    }
    
    /**
     * <ul>
     * <li>Description:[测试main方法]</li>
     * <li>Created by [Huyvanpull] [Jan 20, 2010]</li>
     * <li>Midified by [modifier] [modified time]</li>
     * <ul>
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
//    	List<ArrayList<String>> dataLst = new POIExcelUtil().read("e:/Book1_shao.xls");
    	
    	
        
    	POIExcelUtil poi = new POIExcelUtil();
    	poi.plan4();
    }
    

    private void plan4() {

    	POIExcelUtil poi = new POIExcelUtil();
		Map<String, Integer> mtMap = poi.getMt();
		Map<String, Integer> stMap = poi.getSt();

        List<ArrayList<String>> dataLst = new POIExcelUtil().read("D:/我的酷盘\\World\\World\\item\\福瑞祥进销存系统\\库存20150725.xlsx");
        dataLst.remove(0);
        System.out.println("size: " + dataLst.size());
        for (ArrayList<String> innerLst : dataLst)
        {
        	String str = null;
        	
        	String value0 = mtMap.get(innerLst.get(0).trim()).toString(); 
        	String value1 = stMap.get(innerLst.get(1).trim()).toString(); 
        	String value2 = innerLst.get(2).trim(); 
        	String value3 = innerLst.get(3).trim(); 
        	String value4 = innerLst.get(4).trim(); 
        	String value5 = innerLst.get(5).trim(); 
        	String value6 = innerLst.get(6).trim(); 
        	String value7 = innerLst.get(7).trim(); 
        	String value8 = innerLst.get(8).trim(); 
        	String value9 = innerLst.get(9).trim(); 
        	String value10 = innerLst.get(10).trim(); 
        	
        	str = "INSERT INTO  tb_cp_rk  (  `id` , `cp_fd` , `cp_material_type` , `cp_structure_type` , `cp_code` , `cp_pro_title`, `cp_rk_count` , `cp_zsh` ,  `cp_aqzk`, `cp_price`, `cp_supplier` , `cp_supplier_number` , `remark`, `cp_chdw`,`cp_cc`, `cp_rk_date` , `cp_jsr` , `version`, `update_data`  )VALUES ( DEFAULT, :cp_fd , :cp_material_type , :cp_structure_type , :cp_code , :cp_pro_title, :cp_rk_count , :cp_zsh , :cp_aqzk, :cp_price, :cp_supplier , :cp_supplier_number , :remark, :cp_chdw, :cp_cc, :cp_rk_date , :cp_jsr , 1 , :update_data ); ";
        	str = str.replaceFirst(":cp_fd", "37");
        	str = str.replaceFirst(":cp_material_type", value0);
        	str = str.replaceFirst(":cp_structure_type", value1);
        	str = str.replaceFirst(":cp_code", "'"+value2+ "'");
        	str = str.replaceFirst(":cp_pro_title", "'"+value3+ "'");
        	str = str.replaceFirst(":cp_rk_count", value4.equals("——")? "0": value4);
        	str = str.replaceFirst(":cp_zsh", "'"+value5+ "'");
        	
        	str = str.replaceFirst(":cp_aqzk", value6.equals("——")|| value6.equals("")? "null" :poi.fmDouble(value6));
        	str = str.replaceFirst(":cp_price", value7);
        	str = str.replaceFirst(":cp_supplier", value8.equals("") ? "NULL" : "'"+value8+ "'");
        	str = str.replaceFirst(":cp_supplier_number", value9.equals("") ? "NULL" : "'"+value9+ "'");
        	str = str.replaceFirst(":remark", "'"+value10 + "'");
        	str = str.replaceFirst(":cp_chdw", "null");
        	str = str.replaceFirst(":cp_cc", "NULL" );
        	str = str.replaceFirst(":cp_rk_date", "'2000-01-01 01:00:00'");
        	str = str.replaceFirst(":create_data", "'2000-01-01 01:00:00'");
        	str = str.replaceFirst(":cp_jsr", "'系统导入'");
        	str = str.replaceFirst(":update_data", "now()");
        	
        	System.out.println(str);
        }
        
       
	}
    
    private void plan3() {
		Map<String, Integer> mtMap = getMt();
		Map<String, Integer> stMap = getSt();

        List<ArrayList<String>> dataLst = new POIExcelUtil().read("D:/我的酷盘\\World\\World\\item\\福瑞祥进销存系统\\库存20150725.xlsx");
        dataLst.remove(0);
        System.out.println("size: " + dataLst.size());
        for (ArrayList<String> innerLst : dataLst)
        {
        	String str = null;
        	
        	String value0 = mtMap.get(innerLst.get(0).trim()).toString(); 
        	String value1 = stMap.get(innerLst.get(1).trim()).toString(); 
        	String value2 = innerLst.get(2).trim(); 
        	String value3 = innerLst.get(3).trim(); 
        	String value4 = innerLst.get(4).trim(); 
        	String value5 = innerLst.get(5).trim(); 
        	String value6 = innerLst.get(6).trim(); 
        	String value7 = innerLst.get(7).trim(); 
        	String value8 = innerLst.get(8).trim(); 
        	String value9 = innerLst.get(9).trim(); 
        	String value10 = innerLst.get(10).trim(); 
        	String value12 = innerLst.get(12).trim(); 
//        	System.out.println(value4);
        	
        	str = "INSERT INTO  tb_cp_rk  (  `id` , `cp_fd` , `cp_material_type` , `cp_structure_type` , `cp_code` , `cp_pro_title`, `cp_rk_count` , `cp_zsh` ,  `cp_aqzk`, `cp_price`, `cp_supplier` , `cp_supplier_number` , `remark`, `cp_chdw`,`cp_cc`, `cp_rk_date` , `cp_jsr` , `version`, `update_data`  )VALUES ( DEFAULT, :cp_fd , :cp_material_type , :cp_structure_type , :cp_code , :cp_pro_title, :cp_rk_count , :cp_zsh , :cp_aqzk, :cp_price, :cp_supplier , :cp_supplier_number , :remark, :cp_chdw, :cp_cc, :cp_rk_date , :cp_jsr , 1 , :update_data ); ";
        	str = str.replaceFirst(":cp_fd", "37");
        	str = str.replaceFirst(":cp_material_type", value0);
        	str = str.replaceFirst(":cp_structure_type", value1);
        	str = str.replaceFirst(":cp_code", "'"+value2+ "'");
        	str = str.replaceFirst(":cp_pro_title", "'"+value3+ "'");
        	str = str.replaceFirst(":cp_rk_count", value4.equals("——")? "0": value4);
        	str = str.replaceFirst(":cp_zsh", "'"+value5+ "'");
        	
        	str = str.replaceFirst(":cp_aqzk", value6.equals("——")|| value6.equals("")? "null" :fmDouble(value6));
        	str = str.replaceFirst(":cp_price", value7);
        	str = str.replaceFirst(":cp_supplier", value8.equals("") ? "NULL" : "'"+value8+ "'");
        	str = str.replaceFirst(":cp_supplier_number", value9.equals("") ? "NULL" : "'"+value9+ "'");
        	str = str.replaceFirst(":remark", "'"+value10 + "'");
        	str = str.replaceFirst(":cp_chdw", "null");
        	str = str.replaceFirst(":cp_cc", value12.equals("")|| value12 == null ? "NULL" :fmDouble(value12) );
        	str = str.replaceFirst(":cp_rk_date", "'2000-01-01 01:00:00'");
        	str = str.replaceFirst(":create_data", "'2000-01-01 01:00:00'");
        	str = str.replaceFirst(":cp_jsr", "'系统导入'");
        	str = str.replaceFirst(":update_data", "now()");
        	
        	 System.out.println(str);
        }
        
       
	}
    
    
    /**
	 * Excel Sheet 2
	 */
	private void plan1() {
		Map<String, Integer> mtMap = getMt();
		Map<String, Integer> stMap = getSt();

        List<ArrayList<String>> dataLst = new POIExcelUtil().read("D:/我的酷盘\\World\\World\\item\\福瑞祥进销存系统\\库存20150725.xlsx");
        dataLst.remove(0);
        System.out.println("size: " + dataLst.size());
        for (ArrayList<String> innerLst : dataLst)
        {
        	String str = null;
        	
        	String value0 = mtMap.get(innerLst.get(0).trim()).toString(); 
        	String value1 = stMap.get(innerLst.get(1).trim()).toString(); 
        	String value2 = innerLst.get(2).trim(); 
        	String value3 = innerLst.get(3).trim(); 
        	String value4 = innerLst.get(4).trim(); 
        	String value5 = innerLst.get(5).trim(); 
        	String value6 = innerLst.get(6).trim(); 
        	String value7 = innerLst.get(7).trim(); 
        	String value8 = innerLst.get(8).trim(); 
        	String value9 = innerLst.get(9).trim(); 
        	String value10 = innerLst.get(10).trim(); 
        	String value11 = innerLst.get(11).trim(); 
//        	System.out.println(value4);
        	
        	str = "INSERT INTO  tb_cp_rk  (  `id` , `cp_fd` , `cp_material_type` , `cp_structure_type` , `cp_code` , `cp_pro_title`, `cp_rk_count` , `cp_zsh` ,  `cp_aqzk`, `cp_price`, `cp_supplier` , `cp_supplier_number` , `remark`, `cp_chdw`, `cp_rk_date` , `cp_jsr` , `version`  )VALUES ( DEFAULT, :cp_fd , :cp_material_type , :cp_structure_type , :cp_code , :cp_pro_title, :cp_rk_count , :cp_zsh , :cp_aqzk, :cp_price, :cp_supplier , :cp_supplier_number , :remark, :cp_chdw, :cp_rk_date , :cp_jsr , 1 ); ";
        	str = str.replaceFirst(":cp_fd", "37");
        	str = str.replaceFirst(":cp_material_type", value0);
        	str = str.replaceFirst(":cp_structure_type", value1);
        	str = str.replaceFirst(":cp_code", "'"+value2+ "'");
        	str = str.replaceFirst(":cp_pro_title", "'"+value3+ "'");
        	str = str.replaceFirst(":cp_rk_count", value4.equals("——")? "0": value4);
        	str = str.replaceFirst(":cp_zsh", "'"+value5+ "'");
        	
        	str = str.replaceFirst(":cp_aqzk", value6.equals("——")? "null" :fmDouble(value6));
        	str = str.replaceFirst(":cp_price", value7);
        	str = str.replaceFirst(":cp_supplier", value8.equals("") ? "NULL" : "'"+value8+ "'");
        	str = str.replaceFirst(":cp_supplier_number", value9.equals("") ? "NULL" : "'"+value9+ "'");
        	str = str.replaceFirst(":remark", "'"+value10 + "'");
        	str = str.replaceFirst(":cp_chdw", "null");
        	str = str.replaceFirst(":cp_rk_date", "'2000-01-01 01:00:00'");
        	str = str.replaceFirst(":create_data", "'2000-01-01 01:00:00'");
        	str = str.replaceFirst(":cp_jsr", "'系统导入'");
        	
        	 System.out.println(str);
        }
        
       
	}

	/**
	 * Excel Sheet 1
	 */
	private void plan0() {
		
		Map<String, Integer> mtMap = getMt();
		Map<String, Integer> stMap = getSt();

        List<ArrayList<String>> dataLst = new POIExcelUtil().read("D:/我的酷盘\\World\\World\\item\\福瑞祥进销存系统\\库存20150725.xlsx");
        dataLst.remove(0);
        System.out.println("size: " + dataLst.size());
        for (ArrayList<String> innerLst : dataLst)
        {
        	String str = null;
        	
        	String value0 = mtMap.get(innerLst.get(0).trim()).toString(); 
        	String value1 = stMap.get(innerLst.get(1).trim()).toString(); 
        	String value2 = innerLst.get(2).trim(); 
        	String value3 = innerLst.get(3).trim(); 
        	String value4 = innerLst.get(4).trim(); 
        	String value5 = innerLst.get(5).trim(); 
        	String value6 = innerLst.get(6).trim(); 
        	String value7 = innerLst.get(7).trim(); 
        	String value8 = innerLst.get(8).trim(); 
        	String value9 = innerLst.get(9).trim(); 
        	String value10 = innerLst.get(10).trim(); 
        	String value11 = innerLst.get(11).trim(); 
        	String value12 = innerLst.get(12).trim(); 
//        	System.out.println(value4);
        	
        	
        	str = "INSERT INTO  tb_cp_rk  (  `id` , `cp_fd` , `cp_material_type` , `cp_structure_type` , `cp_code` , `cp_pro_title`, `cp_rk_count` , `cp_zsh` , `cp_cc` , `cp_aqzk`, `cp_price`, `cp_supplier` , `cp_supplier_number` , `remark`, `cp_chdw`, `cp_rk_date` , `cp_jsr` , `version`  )VALUES ( DEFAULT, :cp_fd , :cp_material_type , :cp_structure_type , :cp_code , :cp_pro_title, :cp_rk_count , :cp_zsh , :cp_cc , :cp_aqzk, :cp_price, :cp_supplier , :cp_supplier_number , :remark, :cp_chdw, :cp_rk_date , :cp_jsr , 1 ); ";
        	str = str.replaceFirst(":cp_fd", "37");
        	str = str.replaceFirst(":cp_material_type", value0);
        	str = str.replaceFirst(":cp_structure_type", value1);
        	str = str.replaceFirst(":cp_code", "'"+value2+ "'");
        	str = str.replaceFirst(":cp_pro_title", "'"+value3+ "'");
        	str = str.replaceFirst(":cp_rk_count", value4.equals("——")? "0": value4);
        	str = str.replaceFirst(":cp_zsh", "'"+value5+ "'");
        	str = str.replaceFirst(":cp_cc",value6.equals("——")? "null" : fmDouble(value6));
        	str = str.replaceFirst(":cp_aqzk", value7.equals("——")? "null" :fmDouble(value7));
        	str = str.replaceFirst(":cp_price", value8);
        	str = str.replaceFirst(":cp_supplier", value9.equals("") ? "NULL" : "'"+value9+ "'");
        	str = str.replaceFirst(":cp_supplier_number", value10.equals("") ? "NULL" : "'"+value10+ "'");
        	str = str.replaceFirst(":remark", "'"+value11 + "'");
        	str = str.replaceFirst(":cp_chdw", "null");
        	str = str.replaceFirst(":cp_rk_date", "'2000-01-01 01:00:00'");
        	str = str.replaceFirst(":create_data", "'2000-01-01 01:00:00'");
        	str = str.replaceFirst(":cp_jsr", "'系统导入'");
        	

        	 System.out.println(str);
        }
        
       
	}
	
	public String fmDouble(String s){
		
		DecimalFormat df = new DecimalFormat("#.00");  
		s = df.format(Double.valueOf(s));
		if(Double.valueOf(s) == 0){
			return "";
		}
        return s;
	}
	
	public static boolean isNumeric(String str){  
	    Pattern pattern = Pattern.compile("[0-9]*");  
	    return pattern.matcher(str).matches();     
	}  

	public Map<String, Integer> getSt() {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put( "项链"     , 52);
		map.put( "摆件"     , 53);
		map.put( "挂件"     , 54);
		map.put( "手镯"     , 55);
		map.put( "手玩件"   , 56);
		map.put( "男款戒指" , 57);
		map.put( "女款戒指" , 58);
		map.put( "毛衣链"   , 59);
		map.put( "戒面"     , 60);
		map.put( "镜子"     , 61);
		return map;
	}

	public Map<String, Integer> getMt() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put( "翡翠"  , 46);
		map.put( "6180"  , 47);
		map.put( "黄龙玉", 48);
		map.put( "水沫玉", 49);
		map.put( "珊瑚"  , 50);
		map.put( "树化玉", 51);
		return map;
	}

	public int getSheetAt() {
		return sheetAt;
	}

	public void setSheetAt(int sheetAt) {
		this.sheetAt = sheetAt;
	}
	
	
	
}
