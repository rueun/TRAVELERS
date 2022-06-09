package com.sp.trip.festival;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.trip.common.APISerializer;

@Controller("festival.festivalController")
@RequestMapping(value = "/festival/*")
public class FestivalController {
	@Autowired
	private FestivalService service;
	
	@Autowired
	private APISerializer apiSerializer;
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() {
		return ".festival.festivalList";
	}
	
	@RequestMapping(value = "calendar", method = RequestMethod.GET)
	public String calendar() {
		return ".festival.festivalCalendar";
	}
	
	@RequestMapping(value = "readCity", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> readCity(@RequestParam String areaCode) {
		
		Festival dto = service.readCity(areaCode);
		
		int cityNum = dto.getNum();
		String cityName = dto.getCityName();
		String logoImg = dto.getLogoImg();
		String cityInfo = dto.getCityInfo();
		
		Map<String, Object> model = new HashMap<>();
		
		model.put("cityNum", cityNum);
		model.put("cityName", cityName);
		model.put("areaCode", areaCode);
		model.put("logoImg", logoImg);
		model.put("cityInfo", cityInfo);
		
		return model;
	}
	
	
	// AJAX - XML로 응답
	@RequestMapping(value = "requestSigungu", produces = "application/xml; charset=utf-8")
	@ResponseBody
	public String Sigungu(
			HttpServletRequest req,
			@RequestParam int areaCode
			) throws Exception {
		String result = "";
		try {
			
	 		int numOfRows = 25;
	 		int pageNo = 1;
	 		
	 		String spec = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode";
	 		spec += "?serviceKey=OXE%2BqFWcBW9SYgR6lvlpIlG%2BXPlSHFJ8mMf5dz6gQwfKrl9ONXPiN9pDLFtJoxAQJrP0W%2F3axVjSVae5y8yjPA%3D%3D" ;
	 		spec += "&numOfRows="+ numOfRows;
	 		spec += "&pageNo="+ pageNo;
	 		spec += "&MobileOS=ETC";
	 		spec += "&MobileApp=travel";
	 		spec += "&areaCode="+areaCode;
	 		
	 		result = apiSerializer.receiveXmlToJson(spec);
	 		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@RequestMapping(value = "requestFestival", produces = "application/xml; charset=utf-8")
	@ResponseBody
	public String Festival(
			HttpServletRequest req,
			@RequestParam String areaCode,
			@RequestParam int count
			) throws Exception {
		String result = "";
		try {
			
	 		int numOfRows = count;
	 		int pageNo = 1;
	 		
	 		String spec = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival";
	 		spec += "?serviceKey=OXE%2BqFWcBW9SYgR6lvlpIlG%2BXPlSHFJ8mMf5dz6gQwfKrl9ONXPiN9pDLFtJoxAQJrP0W%2F3axVjSVae5y8yjPA%3D%3D" ;
	 		spec += "&numOfRows="+ numOfRows;
	 		spec += "&pageNo="+ pageNo;
	 		spec += "&arrange=B";
	 		spec += "&listYN=Y";
	 		spec += "&MobileOS=ETC";
	 		spec += "&MobileApp=travel";
	 		spec += "&eventStartDate=20220101";
	 		spec += "&eventEndDate=20221231";
	 		if(!areaCode.equals("NULL")) {
	 			spec += "&areaCode="+areaCode;
	 		}
	 		
	 		result = apiSerializer.receiveXmlToJson(spec);
	 		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	// AJAX - XML로 응답
	// 축제 카테고리 가져오기
	@RequestMapping(value = "requsetServiceCode", produces = "application/xml; charset=utf-8")
	@ResponseBody
	public String serviceCode(
			HttpServletRequest req,			
			@RequestParam int cat1,
			@RequestParam int cat2,
			@RequestParam int cat3
			) throws Exception {
		
		String result = "";
		try {
	 		String spec = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/categoryCode";
	 		spec += "?serviceKey=OXE%2BqFWcBW9SYgR6lvlpIlG%2BXPlSHFJ8mMf5dz6gQwfKrl9ONXPiN9pDLFtJoxAQJrP0W%2F3axVjSVae5y8yjPA%3D%3D" ;
	 		spec += "&MobileOS=ETC";
	 		spec += "&MobileApp=travel";
	 		spec += "&cat1="+cat1;
	 		spec += "&cat2="+cat2;
	 		spec += "&cat3="+cat3;
	 		
	 		result = apiSerializer.receiveXmlToJson(spec);
	 		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}



