package com.luuuzi.server;

import android.os.Parcel;
import android.os.Parcelable;
//2.创建一个book类实现Parcelable用于数据的封装便于交互
/**
 * author : Luuuzi
 * e-mail : wang1143303@163.com
 * date   : 2020/3/9 0009 16:55
 * desc   :
 */
public class Book implements Parcelable {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }
    public void readFromParcel(Parcel in){
        this.name=in.readString();
    }
    protected Book(Parcel in) {
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}

