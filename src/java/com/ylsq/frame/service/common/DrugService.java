/**
 * 
 */
package com.ylsq.frame.service.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.ylsq.frame.dict.common.DrugType;
import com.ylsq.frame.model.common.Drug;
import com.ylsq.frame.model.common.Provider;
import com.ylsq.frame.utils.PoiHelper;
import com.ylsq.frame.utils.StringHelper;

/**
 * @author hopper
 *
 */
@Service
public class DrugService extends CommonService {
	@Resource
	private ProviderService providerService;
	
	public boolean parseExcel(HSSFWorkbook book){
		HSSFSheet sheet = book.getSheetAt(0);//获取第一个sheet
		int rowNum = sheet.getLastRowNum();
		List<Drug> drugList = new ArrayList<Drug>(rowNum);
		for(int i=1;i<=rowNum;i++){
			HSSFRow row = sheet.getRow(i);
			String drugName = PoiHelper.parseCell(row.getCell(0), String.class);
			String drugType = PoiHelper.parseCell(row.getCell(1), String.class);
			String providerName = PoiHelper.parseCell(row.getCell(2), String.class);
			String drugUnit = PoiHelper.parseCell(row.getCell(3), String.class);
			Integer guaranteeMonth = PoiHelper.parseCell(row.getCell(4), Integer.class);
			String approvalNumber = PoiHelper.parseCell(row.getCell(5), String.class);
			String productModel = PoiHelper.parseCell(row.getCell(6), String.class);
			String manufacturer = PoiHelper.parseCell(row.getCell(7), String.class);
			String drugForm = PoiHelper.parseCell(row.getCell(8), String.class);
			Drug drug = new Drug();
			drug.setDrugName(drugName);
			drug.setDrugType(DrugType.convert(drugType));
			if(StringUtils.isNotBlank(providerName)){
				Provider prov = providerService.findProviderByName(providerName);
				if(prov == null){
					prov = new Provider();
					prov.setProviderName(providerName);
					providerService.saveOrUpdateModel(Provider.class, prov);
				}
				drug.setDrugProvider(prov);
			}
			drug.setDrugUnit(drugUnit);
			drug.setGuaranteeMonth(guaranteeMonth);
			drug.setApprovalNumber(approvalNumber);
			drug.setProductModel(productModel);
			drug.setManufacturer(manufacturer);
			drug.setDrugForm(drugForm);
			drug.setSimpleSpell(StringHelper.getSimpleSpell(drugName));
			drugList.add(drug);
		}
		return saveAll(Drug.class, drugList);
	}
	
	public boolean exportExcel(HSSFWorkbook book){
		HSSFSheet sheet = book.createSheet("药品信息");
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("药品名称");
		cell = row.createCell(1);
		cell.setCellValue("药品类型");
		cell = row.createCell(2);
		cell.setCellValue("供应商");
		cell = row.createCell(3);
		cell.setCellValue("单位");
		cell = row.createCell(4);
		cell.setCellValue("保持期(月)");
		cell = row.createCell(5);
		cell.setCellValue("批准文号");
		cell = row.createCell(6);
		cell.setCellValue("规格");
		cell = row.createCell(7);
		cell.setCellValue("生产厂商");
		List<Drug> drugList = findAll(Drug.class);
		for(int index=0;index<drugList.size();index++){
			Drug drug = drugList.get(index);
			row = sheet.createRow(index+1);
			int cnt = 0;
			cell = row.createCell(cnt++);
			cell.setCellValue(drug.getDrugName());
			cell = row.createCell(cnt++);
			if(drug.getDrugType() != null){
				cell.setCellValue(drug.getDrugType().getLabel());
			}
			cell = row.createCell(cnt++);
			if(drug.getDrugProvider() != null){
				cell.setCellValue(drug.getDrugProvider().getProviderName());
			}
			cell = row.createCell(cnt++);
			cell.setCellValue(drug.getDrugUnit());
			cell = row.createCell(cnt++);
			cell.setCellValue(drug.getGuaranteeMonth());
			cell = row.createCell(cnt++);
			cell.setCellValue(drug.getApprovalNumber());
			cell = row.createCell(cnt++);
			cell.setCellValue(drug.getProductModel());
			cell = row.createCell(cnt++);
			cell.setCellValue(drug.getManufacturer());
		}
		return true;
	}
}
