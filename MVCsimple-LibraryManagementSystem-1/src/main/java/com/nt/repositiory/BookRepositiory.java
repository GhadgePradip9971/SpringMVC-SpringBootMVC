package com.nt.repositiory;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.Book;

public interface BookRepositiory extends CrudRepository<Book, Long> {

}
