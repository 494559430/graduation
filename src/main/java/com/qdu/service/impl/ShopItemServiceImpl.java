package com.qdu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bean.ShopItem_Descript;
import com.qdu.bean.Shopitem;
import com.qdu.bean.Shopitemdescrip;
import com.qdu.mapper.ShopitemMapper;
import com.qdu.mapper.ShopitemdescripMapper;
import com.qdu.service.ShopItemService;
import com.qdu.utils.ExcelUtil;
import com.qdu.utils.ResultMsg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.qdu.utils.ExcelUtil.*;

/**
 * Created by 85181 on 2019/4/21.
 */
@Service
public class ShopItemServiceImpl implements ShopItemService {
    @Autowired
    ShopitemMapper shopitemMapper;

    @Autowired
    ShopitemdescripMapper shopitemdescripMapper;


    @Override
    public Map<String, Object> getList(Integer page, Integer rows, ShopItem_Descript shopitem_descript) {

        List<ShopItem_Descript> list = shopitemdescripMapper.getList(shopitem_descript);
        PageHelper.startPage(page, rows);
        PageInfo<ShopItem_Descript> pi = new PageInfo<>(list);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", list);
        result.put("total", pi.getTotal());
        return result;
    }

    @Override
    public Shopitemdescrip getItemDetail() {
        return null;
    }

    @Override
    public Shopitemdescrip getDetail(Integer shopitemid) {
        return shopitemdescripMapper.selectByPrimaryKey(shopitemid);
    }

    @Override
    public int update(Shopitemdescrip shopitemdescrip) {
        int i = shopitemdescripMapper.updateByPrimaryKey(shopitemdescrip);
        return i;
    }

    @Override
    public int add(Shopitemdescrip shopitemdescrip) {
        return shopitemdescripMapper.insert(shopitemdescrip);
    }

    @Override
    public int add(Shopitem shopitem) {
        return shopitemMapper.insert(shopitem);
    }

    @Override
    public ResultMsg add(int shopId, MultipartFile file) {
        ResultMsg msg = new ResultMsg();
        StringBuffer resultMsg = new StringBuffer();
        Workbook workbook = ExcelUtil.getWorkbookByMultipartFile(file, null);
        if (workbook != null) {
            Sheet sheet = workbook.getSheetAt(0);
            //列对应下标，所有列均为重要列，所以不再定义一个重要列的下标
            int[] columnIndex = {-1, -1, -1, -1, -1, -1};
            //对应列名 商品名称	商品价格	商品描述	商品种类	是否上架	供货商
            String[] columnNames = {"商品名称", "商品价格", "商品描述", "商品种类", "是否上架", "供货商"};
            //文件最大行数
            int maxRow = sheet.getLastRowNum();
            if (maxRow == 0) {
                closeWorkBook(workbook);
                throw new RuntimeException("上传文件文件为空，请检查后重试");
            }
            for (Row r : sheet) {
                //如果首行为空，抛出异常
                if (r == null) {
                    closeWorkBook(workbook);
                    throw new RuntimeException("确保文件第一行为标题行");
                }
                //模板文件变动解决
                for (Cell c : r) {
                    if ("商品名称".equals(getStringValue(c))) {
                        columnIndex[0] = c.getColumnIndex();
                    } else if ("商品价格".equals(getStringValue(c))) {
                        columnIndex[1] = c.getColumnIndex();
                    } else if ("商品描述".equals(getStringValue(c))) {
                        columnIndex[2] = c.getColumnIndex();
                    } else if ("商品种类".equals(getStringValue(c))) {
                        columnIndex[3] = c.getColumnIndex();
                    } else if ("是否上架".equals(getStringValue(c))) {
                        columnIndex[4] = c.getColumnIndex();
                    } else if ("供货商".equals(getStringValue(c))) {
                        columnIndex[5] = c.getColumnIndex();
                    }
                }

                StringBuffer info = new StringBuffer("表中缺少以下字段--->");
                //判断需要的重要字段信息是否存在
                for (int i = 0; i < columnIndex.length; i++) {
                    if (columnIndex[i] == -1) {
                        info.append(columnNames[i]).append(",");
                    }
                }
                if (info.toString().contains(",")) {
                    closeWorkBook(workbook);
                    throw new RuntimeException(info.toString());
                }
                break;
            }
            int index = 0;
            try {
                for (Row r : sheet) {
                    index++;
                    if (r != null && index > 1) {
                        //{"商品名称", "商品价格", "商品描述", "商品种类", "是否上架", "供货商"};
                        Shopitemdescrip shopitemdescrip = new Shopitemdescrip();
                        shopitemdescrip.setShopitemname(getCellValue(r.getCell(columnIndex[0])));
                        shopitemdescrip.setPrice(getDoubleValue(r.getCell(columnIndex[1])));
                        shopitemdescrip.setShopitemtype(getIntegerValue(r.getCell(columnIndex[3])));
                        shopitemdescrip.setSupplierid(getIntegerValue(r.getCell(columnIndex[5])));
                        shopitemdescrip.setDescrip(getCellValue(r.getCell(columnIndex[2])));
                        int i = add(shopitemdescrip);
                        Shopitem shopitem = new Shopitem();
                        shopitem.setShopid(shopId);
                        shopitem.setShopitemid(shopitemdescrip.getShopitemid());
                        //默认上架
                        shopitem.setIfgrounding(getIntegerValue(r.getCell(columnIndex[4])));
                        shopitem.setNum(0);
                        add(shopitem);

                        if(i < 1) {
                            resultMsg.append("数据解析失败，行号:").append(index).append(",");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                resultMsg.append("数据解析失败，行号:").append(index).append(",");
            } finally {
                closeWorkBook(workbook);
            }
        }
        if(resultMsg.length() != 0) {
            msg.setCode(500);
            msg.setMsg(resultMsg.toString());
        } else {
            msg.setCode(200);
            msg.setMsg("数据导入成功");
        }
        return msg;
    }

    @Override
    public ShopItem_Descript getDetail2(Integer shopitemid, Integer shopid) {
        return shopitemdescripMapper.selectByPrimaryKey2(shopitemid, shopid);
    }

    @Override
    public void updateShopItem(Shopitem shopitem) {
        shopitemMapper.updateShopItem(shopitem);
    }


}
