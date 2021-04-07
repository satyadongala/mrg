package com.tc.service;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tc.excel_export.ExcelHelper;
import com.tc.exception.ResourceNotFoundException;
import com.tc.model.MrgModel;
import com.tc.repository.MrgRepository;

@Service
public class MrgService {

	@Autowired
	MrgRepository mrgRepository;

	public List<MrgModel> getList() {
		List<MrgModel> list = new ArrayList<MrgModel>();
		list = mrgRepository.findAll();
		return list;
	}

	public MrgModel addRecord(MrgModel mrgModel) {
		MrgModel mrg = mrgRepository.save(mrgModel);
		return mrg;
	}

	public MrgModel getById(Long id) {
		MrgModel mrg = mrgRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found"));
		return mrg;
	}

	public MrgModel update(MrgModel mrgModel, Long id) {
		MrgModel mrg = mrgRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found"));
		mrg.setName(mrgModel.getName());
		mrg.setAmount(mrgModel.getAmount());
		mrg.setVillage(mrgModel.getVillage());
		MrgModel update = mrgRepository.save(mrg);
		return update;
	}

	public ByteArrayInputStream load() {
		List<MrgModel> list = mrgRepository.findAll();
		ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(list);
		return in;
	}

}
