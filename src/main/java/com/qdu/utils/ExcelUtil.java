package com.qdu.utils;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class ExcelUtil {

    public static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    /**
     * @param file   要处理的文件
     * @param params 可选，创建.xlsx 对应的workbook时的参数
     *               params[0]:默认读取行数,params[1]:默认缓冲区大小,bytes
     * @return workbook对象
     */
    public static Workbook getWorkbookByMultipartFile(MultipartFile file, String taskId, int... params) {
        if (file.isEmpty() || file.getSize() == 0) {
            throw new RuntimeException("上传文件为空!");
        }
        String filename = file.getOriginalFilename();
        Workbook workbook = null;
        if (filename.toLowerCase().endsWith(".xls")) {
            try {
                workbook = new HSSFWorkbook(file.getInputStream());
            } catch (IOException e) {
                logger.error(e.getMessage());
                throw new RuntimeException("文件解析异常!");
            }
        } else if (filename.toLowerCase().endsWith(".xlsx")) {
            try {
                //workbook = new XSSFWorkbook(file.getInputStream());
                int rowCacheSize = 500;
                int bufferSize = 16384;
                workbook = StreamingReader.builder()
                        .rowCacheSize(rowCacheSize)
                        .bufferSize(bufferSize)
                        .open(file.getInputStream());
            } catch (IOException e) {
                logger.error(e.getMessage());
                throw new RuntimeException("文件解析异常!");
            }
        } else {
            throw new RuntimeException("文件类型有误!");
        }
        if (workbook == null) {
            throw new RuntimeException("文件解析失败!");
        }
        return workbook;
    }

    public static void closeWorkBook(Workbook workbook) {
        if (workbook != null) {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("WorkBook关闭时出现异常");
            }
        }
    }

    /**
     * 任务ID,当文件解析遇到错误时，设置进度为-1.0
     *
     * @param taskId
     */
    /*private static void setProgress(String taskId) {
        FileProcessingProgress progress = FileProcessingProgress.getInstance();
        if (taskId != null) {
            progress.put(taskId, -1.0);
        }
    }*/

    /**
     * 根据单元格类型获取单元格值
     *
     * @param cell 单元格对象
     * @return 单元格的值
     */
    public static String getCellValue(Cell cell) {
        //防止空指针
        if (cell == null) {
            return null;
        }
        String value = null;
        switch (cell.getCellType()) {
            case NUMERIC: // 数字
                //如果为时间格式的内容
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    //注：format格式 yyyy-MM-dd hh:mm:ss 中小时为12小时制，若要24小时制，则把小h变为H即可，yyyy-MM-dd HH:mm:ss
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    value = sdf.format(HSSFDateUtil.getJavaDate(cell.
                            getNumericCellValue())).toString();
                    break;
                } else {
                    value = new DecimalFormat("##########.######").format(cell.getNumericCellValue());
                }
                break;
            case STRING: // 字符串
                value = cell.getStringCellValue();
                break;
            case BOOLEAN: // Boolean
                value = cell.getBooleanCellValue() + "";
                break;
            case FORMULA: // 公式
                value = cell.getCellFormula() + "";
                break;
            case BLANK: // 空值
                value = null;
                break;
            case ERROR: // 故障
                value = null;
                break;
            default:
                value = null;
                break;
        }
        return value;
    }

    public static String getStringValue(Cell cell) {
        if (isCellNull(cell)) {
            return null;
        }
        return getCellValue(cell);
    }

    public static Integer getIntegerValue(Cell cell) {
        if (isCellNull(cell)) {
            return null;
        }
        try {
            return Integer.parseInt(getCellValue(cell));
        } catch (Exception e) {
            return null;
        }
    }

    public static Double getDoubleValue(Cell cell) {
        if (isCellNull(cell)) {
            return null;
        }
        try {
            return Double.parseDouble(getCellValue(cell));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将字符串进行处理
     *
     * @param cellValue
     * @return
     */
    public static String converStringNull2NullString(String cellValue) {
        if (cellValue == null || "NULL".equals(cellValue.trim())) {
            return null;
        }
        return cellValue;
    }

    /**
     * 将单元格的数据转为String并处理
     *
     * @param cell
     * @return
     */
    public static String converStringNull2NullString(Cell cell) {
        return converStringNull2NullString(ExcelUtil.getCellValue(cell));
    }

    /**
     * 将字符串转换为数字
     *
     * @param cellValue
     * @return
     */
    public static Integer converString2Integer(String cellValue) {
        if (cellValue == null || cellValue.trim().equals("NULL") || "".equals(cellValue.trim())) {
            return null;
        }
        try {
            return Integer.parseInt(cellValue);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
    }

    /**
     * 将单元格的数据转为Integer
     *
     * @param cell
     * @return
     */
    public static Integer converString2Integer(Cell cell) {
        return converString2Integer(getStringValue(cell));
    }

    public static int converString2Int(Cell cell) {
        Integer temp = converString2Integer(cell);
        return temp == null ? 0 : temp;
    }

    /**
     * 将字符串转换为浮点数字
     *
     * @param cellValue
     * @return
     */
    public static Double converString2Double(String cellValue) {
        if (cellValue == null || cellValue.trim().equals("NULL") || "".equals(cellValue.trim())) {
            return null;
        }
        try {
            return Double.parseDouble(cellValue);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
    }

    /**
     * 将单元格的数据转为Integer
     *
     * @param cell
     * @return
     */
    public static Double converString2Double(org.apache.poi.ss.usermodel.Cell cell) {
        return converString2Double(ExcelUtil.getCellValue(cell));
    }

    /**
     * 判断单元格是否为空
     *
     * @param cell
     * @return
     */
    public static boolean isCellNull(Cell cell) {
        if (cell == null || "".equals(getCellValue(cell).trim()) ||
                "NULL".equals(getCellValue(cell))) {
            return true;
        }
        return false;
    }

}
