package com.tc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tc.model.MrgModel;
import com.tc.service.MrgService;
@CrossOrigin(origins = "http://192.168.1.7:8080")
@RestController
@RequestMapping("/mrg")
public class MrgController {

	@Autowired
	MrgService mrgService;

	@GetMapping()
	@ResponseBody
	public List<MrgModel> list() {
		List<MrgModel> list = new ArrayList<MrgModel>();
		list = mrgService.getList();
		return list;
	}

	@PostMapping()
	@ResponseBody
	public MrgModel add(@RequestBody MrgModel mrgModel) {
		MrgModel mrg = mrgService.addRecord(mrgModel);
		return mrg;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public MrgModel getById(@PathVariable(value = "id") Long id) {
		MrgModel mrg = mrgService.getById(id);
		return mrg;
	}

	@PutMapping("/{id}")
	@ResponseBody
	public MrgModel update(@RequestBody MrgModel mrgModel, @PathVariable(value = "id") Long id) {
		MrgModel mrg = mrgService.update(mrgModel, id);
		return mrg;
	}

	@GetMapping("/download")
	public ResponseEntity<InputStreamResource> getFile() {
		String filename = "marriage.xlsx";
		InputStreamResource file = new InputStreamResource(mrgService.load());

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}
}
