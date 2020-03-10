// BookController.aidl
package com.luuuzi.server;
//引入book类
import com.luuuzi.server.Book;
// Declare any non-default types here with import statements

interface BookController {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
//获取书籍列表
    List<Book> getBookList();
//    添加书籍
    void addBookInOut(inout Book book);
}
