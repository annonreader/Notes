package com.practice.tarun.notes.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class note implements Parcelable {

    private String title;
    private String timestamp;
    private String content;

    public note(String title, String timestamp, String content) {
        this.title = title;
        this.timestamp = timestamp;
        this.content = content;
    }

    public note() {
    }

    protected note(Parcel in) {
        title = in.readString();
        timestamp = in.readString();
        content = in.readString();
    }

    public static final Creator<note> CREATOR = new Creator<note>() {
        @Override
        public note createFromParcel(Parcel in) {
            return new note(in);
        }

        @Override
        public note[] newArray(int size) {
            return new note[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    @Override
    public String toString() {
        return "note{" +
                "title='" + title + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(timestamp);
        parcel.writeString(content);
    }
}