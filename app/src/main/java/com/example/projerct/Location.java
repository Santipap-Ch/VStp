package com.example.projerct;

import java.util.ArrayList;

public class Location {
    private String location;
    private String name;
    private double latitude;
    private double longtitude;

    private ArrayList<Location> locations = new ArrayList<>();

    public Location() {
    }

    public Location(String location, String name, double latitude, double longtitude) {
        this.location = location;
        this.name = name;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }


    public ArrayList<Location> getLocations() {
        this.locations.add(new Location("เลือกสถานที่",null,0, 0));
        this.locations.add(new Location("อาคาร 1","คณะเทคโนโลยีและสิ่งแวดล้อม",7.894764, 98.352078));
        this.locations.add(new Location("อาคาร 2","คณะการบริการ และการท่องเที่ยว",7.894127, 98.352007));
        this.locations.add(new Location("อาคาร 3","คณะวิเทศศึกษา",7.893784, 98.352957));
        this.locations.add(new Location("อาคาร 5","อาคารวิทยบริการ(ห้องสมุด)",7.893475, 98.353487));
        this.locations.add(new Location("อาหาร 6","อาคารเรียนรวม และห้องปฏิบัติการกลาง",7.893364, 98.352195));
        this.locations.add(new Location("อาคาร 7","สำนักงานอธิการบดี วิทยาเขตภูเก็ต",7.894527, 98.352879));
        this.locations.add(new Location("อาคาร 9","อาคารศูนย์การจัดการเรียนการสอนนานาชาติ และพัฒนานักศึกษา",7.896794, 98.352356));
        this.locations.add(new Location("วิทยาลัยการคอมพิวเตอร์","College of Computing",7.893328, 98.352353));
        this.locations.add(new Location("ภาควิชาวิศวกรรมคอมพิวเตอร์","Department of Computer Engineering",7.893328, 98.352353));
        this.locations.add(new Location("คณะเทคโนโลยีและสิ่งแวดล้อม","Faculty of Technology and Environment",7.894764, 98.352078));
        this.locations.add(new Location("คณะการบริการ","Faculty of Hospitality and Tourism",7.894127, 98.352007));
        this.locations.add(new Location("คณะวิเทศศึกษา","Faculty of International Studies",7.893784, 98.352957));
        this.locations.add(new Location("อาคารวิทยบริการ (ห้องสมุด)","Academic Service",7.893475, 98.353487));
        this.locations.add(new Location("อาคารเรียนรวม และห้องปฏิบัติการกลาง","Central Academic and Laboratory Facility",7.893364, 98.352195));
        this.locations.add(new Location("สำนักงานอธิการบดี วิทยาเขตภูเก็ต","The President's Office, Phuket Campus",7.894527, 98.352879));
        this.locations.add(new Location("อาคารศูนย์การจัดการเรียนการสอนนานาชาติ และพัฒนานักศึกษา","PSU Phuket Sports Complex",7.896794, 98.352356));
        this.locations.add(new Location("Male Dormitory","หอพักนักศึกษาชาย",7.892734, 98.354802));
        this.locations.add(new Location("สนามบาสเกตบอล","PSU Phuket Basketball Court",7.893056, 98.353726));
        return locations;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    @Override
    public String toString() {
        return location;
    }
}
