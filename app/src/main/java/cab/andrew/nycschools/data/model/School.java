package cab.andrew.nycschools.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.squareup.moshi.Json;

@Entity(tableName = "schools")
public class School implements Parcelable {

	private int id;
	@NonNull
	@PrimaryKey
	@Json(name = "dbn")
	@ColumnInfo(name = "dbn")
	private String dbn;
	@Json(name = "school_name")
	@ColumnInfo(name = "school_name")
	private String schoolName;
	@Json(name = "borough")
	@ColumnInfo(name = "borough")
	private String borough;
	@Json(name = "building_code")
	@ColumnInfo(name = "building_code")
	private String buildingCode;
	@Json(name = "total_students")
	@ColumnInfo(name = "total_students")
	private int totalStudents;
	@Json(name = "start_time")
	@ColumnInfo(name = "start_time")
	private String startTime;
	@Json(name = "end_time")
	@ColumnInfo(name = "end_time")
	private String endTime;
	@Json(name = "overview_paragraph")
	@ColumnInfo(name = "overview_paragraph")
	private String overview_paragraph;
	@Json(name = "addtl_info1")
	@ColumnInfo(name = "addtl_info1")
	private String addtlInfo;
	@Json(name="ell_programs")
	@ColumnInfo(name="ell_programs")
	private String ellPrograms;
	@Json(name="language_classes")
	@ColumnInfo(name="language_classes")
	private String langClasses;
	@Json(name = "final_grades")
	@ColumnInfo(name = "final_grades")
	private String finalGrades;
	@Json(name = "subway")
	@ColumnInfo(name = "subway")
	private String subway;
	@Json(name = "bus")
	@ColumnInfo(name = "bus")
	private String bus;
	@Json(name = "requirement1_1")
	@ColumnInfo(name = "requirement1_1")
	private String requirement1;
	@Json(name = "requirement2_1")
	@ColumnInfo(name = "requirement2_1")
	private String requirement2;
	@Json(name = "requirement3_1")
	@ColumnInfo(name = "requirement3_1")
	private String requirement3;
	@Json(name = "requirement4_1")
	@ColumnInfo(name = "requirement4_1")
	private String requirement4;
	@Json(name = "requirement5_1")
	@ColumnInfo(name = "requirement5_1")
	private String requirement5;
	@Json(name = "academicopportunities1")
	@ColumnInfo(name = "academicopportunities1")
	private String academicOpportunities1;
	@Json(name = "academicopportunities2")
	@ColumnInfo(name = "academicopportunities2")
	private String academicOpportunities2;
	@Json(name = "academicopportunities3")
	@ColumnInfo(name = "academicopportunities3")
	private String academicOpportunities3;
	@Json(name = "academicopportunities4")
	@ColumnInfo(name = "academicopportunities4")
	private String academicOpportunities4;
	@Json(name = "academicopportunities5")
	@ColumnInfo(name = "academicopportunities5")
	private String academicOpportunities5;
	@Json(name = "advancedplacement_courses")
	@ColumnInfo(name = "advancedplacement_courses")
	private String advancePlacementCourses;
	@Json(name = "extracurricular_activities")
	@ColumnInfo(name = "extracurricular_activities")
	private String extracurricularActivities;
	@Json(name = "school_sports")
	@ColumnInfo(name = "school_sports")
	private String schoolSports;
	@Json(name = "attendance_rate")
	@ColumnInfo(name = "attendance_rate")
	private float attendanceRate;
	@Json(name = "graduation_rate")
	@ColumnInfo(name = "graduation_rate")
	private float graduationRate;
	@Json(name = "college_career_rate")
	@ColumnInfo(name = "college_career_rate")
	private float collegeCareerRate;
	@Json(name = "school_email")
	@ColumnInfo(name = "school_email")
	private String schoolEmail;
	@Json(name = "website")
	@ColumnInfo(name = "website")
	private String website;
	@Json(name = "phone_number")
	@ColumnInfo(name = "phone_number")
	private String phoneNumber;
	@Json(name = "fax_number")
	@ColumnInfo(name = "fax_number")
	private String faxNumber;
	@Json(name = "neighborhood")
	@ColumnInfo(name = "neighborhood")
	private String neighborhood;
	@Json(name = "primary_address_line_1")
	@ColumnInfo(name = "primary_address_line_1")
	private String primaryAddressLine;
	@Json(name = "state_code")
	@ColumnInfo(name = "state_code")
	private String stateCode;
	@Json(name = "city")
	@ColumnInfo(name = "city")
	private String city;
	@Json(name = "zip")
	@ColumnInfo(name = "zip")
	private String zip;
	@Json(name = "latitude")
	@ColumnInfo(name = "latitude")
	private float latitude;
	@Json(name = "longitude")
	@ColumnInfo(name = "longitude")
	private float longitude;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDbn() {
		return dbn;
	}

	public void setDbn(String dbn) {
		this.dbn = dbn;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getBorough() {
		return borough;
	}

	public void setBorough(String borough) {
		this.borough = borough;
	}

	public String getBuildingCode() {
		return buildingCode;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	public int getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getOverview_paragraph() {
		return overview_paragraph;
	}

	public void setOverview_paragraph(String overview_paragraph) {
		this.overview_paragraph = overview_paragraph;
	}

	public String getAddtlInfo() {
		return addtlInfo;
	}

	public void setAddtlInfo(String addtlInfo) {
		this.addtlInfo = addtlInfo;
	}

	public String getEllPrograms() {
		return ellPrograms;
	}

	public void setEllPrograms(String ellPrograms) {
		this.ellPrograms = ellPrograms;
	}

	public String getLangClasses() {
		return langClasses;
	}

	public void setLangClasses(String langClasses) {
		this.langClasses = langClasses;
	}

	public String getFinalGrades() {
		return finalGrades;
	}

	public void setFinalGrades(String finalGrades) {
		this.finalGrades = finalGrades;
	}

	public String getSubway() {
		return subway;
	}

	public void setSubway(String subway) {
		this.subway = subway;
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public String getRequirement1() {
		return requirement1;
	}

	public void setRequirement1(String requirement1) {
		this.requirement1 = requirement1;
	}

	public String getRequirement2() {
		return requirement2;
	}

	public void setRequirement2(String requirement2) {
		this.requirement2 = requirement2;
	}

	public String getRequirement3() {
		return requirement3;
	}

	public void setRequirement3(String requirement3) {
		this.requirement3 = requirement3;
	}

	public String getRequirement4() {
		return requirement4;
	}

	public void setRequirement4(String requirement4) {
		this.requirement4 = requirement4;
	}

	public String getRequirement5() {
		return requirement5;
	}

	public void setRequirement5(String requirement5) {
		this.requirement5 = requirement5;
	}

	public String getAcademicOpportunities1() {
		return academicOpportunities1;
	}

	public void setAcademicOpportunities1(String academicOpportunities1) {
		this.academicOpportunities1 = academicOpportunities1;
	}

	public String getAcademicOpportunities2() {
		return academicOpportunities2;
	}

	public void setAcademicOpportunities2(String academicOpportunities2) {
		this.academicOpportunities2 = academicOpportunities2;
	}

	public String getAcademicOpportunities3() {
		return academicOpportunities3;
	}

	public void setAcademicOpportunities3(String academicOpportunities3) {
		this.academicOpportunities3 = academicOpportunities3;
	}

	public String getAcademicOpportunities4() {
		return academicOpportunities4;
	}

	public void setAcademicOpportunities4(String academicOpportunities4) {
		this.academicOpportunities4 = academicOpportunities4;
	}

	public String getAcademicOpportunities5() {
		return academicOpportunities5;
	}

	public void setAcademicOpportunities5(String academicOpportunities5) {
		this.academicOpportunities5 = academicOpportunities5;
	}

	public String getAdvancePlacementCourses() {
		return advancePlacementCourses;
	}

	public void setAdvancePlacementCourses(String advancePlacementCourses) {
		this.advancePlacementCourses = advancePlacementCourses;
	}

	public String getExtracurricularActivities() {
		return extracurricularActivities;
	}

	public void setExtracurricularActivities(String extracurricularActivities) {
		this.extracurricularActivities = extracurricularActivities;
	}

	public String getSchoolSports() {
		return schoolSports;
	}

	public void setSchoolSports(String schoolSports) {
		this.schoolSports = schoolSports;
	}

	public float getAttendanceRate() {
		return attendanceRate;
	}

	public void setAttendanceRate(float attendanceRate) {
		this.attendanceRate = attendanceRate;
	}

	public float getGraduationRate() {
		return graduationRate;
	}

	public void setGraduationRate(float graduationRate) {
		this.graduationRate = graduationRate;
	}

	public float getCollegeCareerRate() {
		return collegeCareerRate;
	}

	public void setCollegeCareerRate(float collegeCareerRate) {
		this.collegeCareerRate = collegeCareerRate;
	}

	public String getSchoolEmail() {
		return schoolEmail;
	}

	public void setSchoolEmail(String schoolEmail) {
		this.schoolEmail = schoolEmail;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getPrimaryAddressLine() {
		return primaryAddressLine;
	}

	public void setPrimaryAddressLine(String primaryAddressLine) {
		this.primaryAddressLine = primaryAddressLine;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public static Creator<School> getCREATOR() {
		return CREATOR;
	}

	public School(){

	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeString(this.dbn);
		dest.writeString(this.schoolName);
		dest.writeString(this.borough);
		dest.writeString(this.buildingCode);
		dest.writeInt(this.totalStudents);
		dest.writeString(this.startTime);
		dest.writeString(this.endTime);
		dest.writeString(this.overview_paragraph);
		dest.writeString(this.addtlInfo);
		dest.writeString(this.ellPrograms);
		dest.writeString(this.langClasses);
		dest.writeString(this.finalGrades);
		dest.writeString(this.subway);
		dest.writeString(this.bus);
		dest.writeString(this.requirement1);
		dest.writeString(this.requirement2);
		dest.writeString(this.requirement3);
		dest.writeString(this.requirement4);
		dest.writeString(this.requirement5);
		dest.writeString(this.academicOpportunities1);
		dest.writeString(this.academicOpportunities2);
		dest.writeString(this.academicOpportunities3);
		dest.writeString(this.academicOpportunities4);
		dest.writeString(this.academicOpportunities5);
		dest.writeString(this.advancePlacementCourses);
		dest.writeString(this.extracurricularActivities);
		dest.writeString(this.schoolSports);
		dest.writeFloat(this.attendanceRate);
		dest.writeFloat(this.graduationRate);
		dest.writeFloat(this.collegeCareerRate);
		dest.writeString(this.schoolEmail);
		dest.writeString(this.website);
		dest.writeString(this.phoneNumber);
		dest.writeString(this.faxNumber);
		dest.writeString(this.neighborhood);
		dest.writeString(this.primaryAddressLine);
		dest.writeString(this.stateCode);
		dest.writeString(this.city);
		dest.writeString(this.zip);
		dest.writeFloat(this.latitude);
		dest.writeFloat(this.longitude);
	}

	protected School(Parcel in) {
		this.id = in.readInt();
		this.dbn = in.readString();
		this.schoolName = in.readString();
		this.borough = in.readString();
		this.buildingCode = in.readString();
		this.totalStudents = in.readInt();
		this.startTime = in.readString();
		this.endTime = in.readString();
		this.overview_paragraph = in.readString();
		this.addtlInfo = in.readString();
		this.ellPrograms = in.readString();
		this.langClasses = in.readString();
		this.finalGrades = in.readString();
		this.subway = in.readString();
		this.bus = in.readString();
		this.requirement1 = in.readString();
		this.requirement2 = in.readString();
		this.requirement3 = in.readString();
		this.requirement4 = in.readString();
		this.requirement5 = in.readString();
		this.academicOpportunities1 = in.readString();
		this.academicOpportunities2 = in.readString();
		this.academicOpportunities3 = in.readString();
		this.academicOpportunities4 = in.readString();
		this.academicOpportunities5 = in.readString();
		this.advancePlacementCourses = in.readString();
		this.extracurricularActivities = in.readString();
		this.schoolSports = in.readString();
		this.attendanceRate = in.readFloat();
		this.graduationRate = in.readFloat();
		this.collegeCareerRate = in.readFloat();
		this.schoolEmail = in.readString();
		this.website = in.readString();
		this.phoneNumber = in.readString();
		this.faxNumber = in.readString();
		this.neighborhood = in.readString();
		this.primaryAddressLine = in.readString();
		this.stateCode = in.readString();
		this.city = in.readString();
		this.zip = in.readString();
		this.latitude = in.readFloat();
		this.longitude = in.readFloat();
	}

	public static final Creator<School> CREATOR = new Creator<School>() {
		@Override
		public School createFromParcel(Parcel source) {
			return new School(source);
		}

		@Override
		public School[] newArray(int size) {
			return new School[size];
		}
	};
}
