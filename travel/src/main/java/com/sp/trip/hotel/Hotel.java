package com.sp.trip.hotel;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Hotel {
	// 숙박업소 테이블
	private int hotelNum;
	private String hotelName;
	private String hotelIntro;
	private String hotelNumber;
	private int hotelZip;
	private String hotelAddr1;
	private String hotelAddr2;
	private List<MultipartFile> selectFile;
	
	// 방테이블
	private int roomNum;
	private String roomName;
	private int roomPrice;
	private int roomHo;
	private int roomBed;
	private int roomMen;
	private String roomOption;
	
	private String partnerName;
	
	
	public int getHotelNum() {
		return hotelNum;
	}
	public void setHotelNum(int hotelNum) {
		this.hotelNum = hotelNum;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelIntro() {
		return hotelIntro;
	}
	public void setHotelIntro(String hotelIntro) {
		this.hotelIntro = hotelIntro;
	}
	public String getHotelNumber() {
		return hotelNumber;
	}
	public void setHotelNumber(String hotelNumber) {
		this.hotelNumber = hotelNumber;
	}
	public int getHotelZip() {
		return hotelZip;
	}
	public void setHotelZip(int hotelZip) {
		this.hotelZip = hotelZip;
	}
	public String getHotelAddr1() {
		return hotelAddr1;
	}
	public void setHotelAddr1(String hotelAddr1) {
		this.hotelAddr1 = hotelAddr1;
	}
	public String getHotelAddr2() {
		return hotelAddr2;
	}
	public void setHotelAddr2(String hotelAddr2) {
		this.hotelAddr2 = hotelAddr2;
	}
	public List<MultipartFile> getSelectFile() {
		return selectFile;
	}
	public void setSelectFile(List<MultipartFile> selectFile) {
		this.selectFile = selectFile;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	public int getRoomHo() {
		return roomHo;
	}
	public void setRoomHo(int roomHo) {
		this.roomHo = roomHo;
	}
	public int getRoomBed() {
		return roomBed;
	}
	public void setRoomBed(int roomBed) {
		this.roomBed = roomBed;
	}
	public int getRoomMen() {
		return roomMen;
	}
	public void setRoomMen(int roomMen) {
		this.roomMen = roomMen;
	}
	public String getRoomOption() {
		return roomOption;
	}
	public void setRoomOption(String roomOption) {
		this.roomOption = roomOption;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	
}
