//package com.tp.libraryUserStories.persistence;
//
//import com.tp.libraryUserStories.exceptions.InvalidAuthorsException;
//import com.tp.libraryUserStories.exceptions.InvalidBookIdException;
//import com.tp.libraryUserStories.exceptions.InvalidPublicationYearException;
//import com.tp.libraryUserStories.exceptions.InvalidTitleException;
//import com.tp.libraryUserStories.models.Book;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
////@Component
//public class PostgresLibraryDao implements LibraryDao{
//
//    @Autowired
//    JdbcTemplate template;
//
//    @Override
//    public int addBooks(String title, List<String> authors, Integer year) throws InvalidTitleException, InvalidAuthorsException, InvalidPublicationYearException {
//        List<Integer> authorList = new ArrayList<>();
//        for(String author: authors){
//            Integer authorId = addOrRetrieve(author);
//            authorList.add(authorId);
//        }
//       return 0;
//    }
//
//    private Integer addOrRetrieve(String author) {
//       Integer authorId = getAuthorId(author);
//        if(authorId == null){
//            authorId = addAuthor(author);
//        }
//        return authorId;
//    }
//
//    private Integer getAuthorId(String author) {
//    List<Integer> id = template.query("select \"authorId\" from \"Author\" where \"authorName\" = '"+ author +"';" ,new IdMapper());
//   if(id.isEmpty())
//       return null;
//   return id.get(0);
//    }
//
//    private Integer addAuthor(String author){
//
//        return template.query("INSERT into \"Author\" (\"authorName\")\n" +
//            "Values ('"+ author +"')\n" +
//            "RETURNING \"authorId\"", new IdMapper()).get(0);
//    }
//
//    @Override
//    public List<Book> getAllBooks() {
//        return null;
//    }
//
//    @Override
//    public Book getAllBookById(Integer id) {
//        return null;
//    }
//
//    @Override
//    public List<Book> getBooksByTitle(String title) throws InvalidTitleException {
//        return null;
//    }
//
//    @Override
//    public List<Book> getBooksByAuthors(String author) throws InvalidAuthorsException {
//        return null;
//    }
//
//    @Override
//    public List<Book> getBooksByYear(Integer year) throws InvalidPublicationYearException {
//        return null;
//    }
//
//    @Override
//    public void updateBook(Book newBook) {
//
//    }
//
//    @Override
//    public void deleteBooks(Integer bookId) throws InvalidBookIdException {
//
//    }
//    private class IdMapper implements RowMapper<Integer> {
//
//        @Override
//        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
//
//            return resultSet.getInt("authorId");
//        }
//    }
//}
