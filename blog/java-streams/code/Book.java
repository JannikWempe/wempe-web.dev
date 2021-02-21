public class Book {
  private String title;
  private int numPages;

  public Book(String title, int numPages) {
    this.title = title;
    this.numPages = numPages;
  }

  @Override
  public String toString() {
    return "Book{" +
      "title='" + title + '\'' +
      ", numPages=" + numPages +
      '}';
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getNumPages() {
    return numPages;
  }

  public void setNumPages(int numPages) {
    this.numPages = numPages;
  }
}
