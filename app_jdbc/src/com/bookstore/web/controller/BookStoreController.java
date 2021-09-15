package com.bookstore.web.controller;

import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import com.bookstore.config.AppConfig;
import com.bookstore.domain.Book;
import com.bookstore.domain.Chapter;
import com.bookstore.domain.ChapterPK;
import com.bookstore.domain.Publisher;
import com.bookstore.service.BookService;

@Controller
public class BookStoreController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("bookapp.xml");
		BookService bookService=ctx.getBean("bookService",BookService.class);
		Book book = new Book("3", "How I became a DemiGod" );
		Publisher publisher = new Publisher("DGH", "DemiGod Hood");
		book.setPublisherCode(publisher);
		int count = 0;
		List<ChapterPK> chapPk = new ArrayList<>();
		chapPk.add(new ChapterPK(book.getIsbn(), count));
		List<Chapter> chap = new ArrayList<>();
		chap.add(new Chapter(chapPk.get(count++),"The Pathway To Hell"));
		

		chapPk.add(new ChapterPK(book.getIsbn(), count));
		chap.add(new Chapter(chapPk.get(count++),"The Beauty of Hell"));
		
		chapPk.add(new ChapterPK(book.getIsbn(), count));
		chap.add(new Chapter(chapPk.get(count++),"My Life As A Demon Lord"));
		
		chapPk.add(new ChapterPK(book.getIsbn(), count));
		chap.add(new Chapter(chapPk.get(count++),"Pathway To God Hood"));
		
		chapPk.add(new ChapterPK(book.getIsbn(), count));
		chap.add(new Chapter(chapPk.get(count++),"Hail Me Mortals I Am A God"));
		
		book.setChapters(chap);
		
		bookService.persistObjectGraph(book);
		
		System.out.println(bookService.retrieveObjectGraph("3"));
	}

}
