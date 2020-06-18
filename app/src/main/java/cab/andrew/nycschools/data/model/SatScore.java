package cab.andrew.nycschools.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.squareup.moshi.Json;

@Entity(tableName = "sat_scores")
public class SatScore implements Parcelable {
	private int id;

	@NonNull
	@PrimaryKey
	@Json(name = "dbn")
	@ColumnInfo(name = "dbn")
	private String dbn;

	@Json(name = "school_name")
	@ColumnInfo(name = "school_name")
	private String schoolName;
	@Json(name = "total_test_takers")
	@ColumnInfo(name = "total_test_takers")
	private String totalTestTakers;
	@Json(name = "critical_reading_score_avg")
	@ColumnInfo(name = "critical_reading_score_avg")
	private String critReadingScoreAvg;
	@Json(name = "math_score_avg")
	@ColumnInfo(name = "math_score_avg")
	private String mathScoreAvg;
	@Json(name = "writing_score_avg")
	@ColumnInfo(name = "writing_score_avg")
	private String writingScoreAvg;

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

	public String getTotalTestTakers() {
		return totalTestTakers;
	}

	public void setTotalTestTakers(String totalTestTakers) {
		this.totalTestTakers = totalTestTakers;
	}

	public String getCritReadingScoreAvg() {
		return critReadingScoreAvg;
	}

	public void setCritReadingScoreAvg(String critReadingScoreAvg) {
		this.critReadingScoreAvg = critReadingScoreAvg;
	}

	public String getMathScoreAvg() {
		return mathScoreAvg;
	}

	public void setMathScoreAvg(String mathScoreAvg) {
		this.mathScoreAvg = mathScoreAvg;
	}

	public String getWritingScoreAvg() {
		return writingScoreAvg;
	}

	public void setWritingScoreAvg(String writingScoreAvg) {
		this.writingScoreAvg = writingScoreAvg;
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
		dest.writeString(this.totalTestTakers);
		dest.writeString(this.critReadingScoreAvg);
		dest.writeString(this.mathScoreAvg);
		dest.writeString(this.writingScoreAvg);
	}

	public SatScore() {
	}

	protected SatScore(Parcel in) {
		this.id = in.readInt();
		this.dbn = in.readString();
		this.schoolName = in.readString();
		this.totalTestTakers = in.readString();
		this.critReadingScoreAvg = in.readString();
		this.mathScoreAvg = in.readString();
		this.writingScoreAvg = in.readString();
	}

	public static final Creator<SatScore> CREATOR = new Creator<SatScore>() {
		@Override
		public SatScore createFromParcel(Parcel source) {
			return new SatScore(source);
		}

		@Override
		public SatScore[] newArray(int size) {
			return new SatScore[size];
		}
	};
}
