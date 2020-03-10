package com.luuuzi.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * author : Luuuzi
 * e-mail : wang1143303@163.com
 * date   : 2020/3/10 0010 9:58
 * desc   : 4.创建一个 Service 供客户端远程绑定了,并在清单文件注册
 */
public class AIDLServer extends Service {
    public static final String tag="AIDLServer";
    private List<Book> bookList;
    public AIDLServer(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        bookList=new ArrayList<>();
        initData();
    }
    private void initData(){
        Book book = new Book("大秦帝国-裂变");
        Book book2 = new Book("大秦帝国-崛起");
        Book book3 = new Book("大秦帝国-纵横");
        Book book4 = new Book("大秦帝国-天下");
        bookList.add(book);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }
    private final BookController.Stub stub=new BookController.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            return bookList;
        }

        @Override
        public void addBookInOut(Book book) throws RemoteException {
            if (book!=null){
                book.setName("服务器改了新书的名字 InOut");
                bookList.add(book);
            }else {
                Log.e(tag,"接收到一个空对象");
            }
        }
    };
}
