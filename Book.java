// Name: Samih Wadi
// Student ID: 501079540
/* A book IS A product that has additional information - e.g. title, author

 	 A book also comes in different formats ("Paperback", "Hardcover", "EBook")
 	 
 	 The format is specified as a specific "stock type" in get/set/reduce stockCount methods.

*/
public class Book extends Product 
{
  private String author;
  private String title;
  private int year;
  
  // Stock related information NOTE: inherited stockCount variable is used for EBooks
  int paperbackStock;
  int hardcoverStock;
  
  public Book(String name, String id, double price, int paperbackStock, int hardcoverStock, String title, String author, int year, int stats)
  {
  	 // Make use of the constructor in the super class Product. Initialize additional Book instance variables. 
  	 // Set category to BOOKS
	  super(name, id, price, 100000, Product.Category.BOOKS, 0);
	  this.title = title;
	  this.author = author;
	  this.paperbackStock = paperbackStock;
	  this.hardcoverStock = hardcoverStock;
	  this.year = year;
  }
    
  // Check if a valid format  
  public boolean validOptions(String productOptions)
  {
  	// check productOptions for "Paperback" or "Hardcover" or "EBook"
  	// if it is one of these, return true, else return false
	  return productOptions.equalsIgnoreCase("PaperBack") || productOptions.equals("EBook") || productOptions.equals("Hardcover");

  }
  public int getYear() // Method to get year
  {
	  return year;
  }
  public String getAuthor() // Method to get author
  {
	  return author;
  }
  
  // Override getStockCount() in super class.
  public int getStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and return) the number of stock for "Paperback" etc
  	// Use the variables paperbackStock and hardcoverStock at the top. 
  	// For "EBook", use the inherited stockCount variable.
	  switch (productOptions)
	  {
	  case "Hardcover": return hardcoverStock;
	  case "Paperback": return paperbackStock;
	  case "Ebook": return super.getStockCount("Ebooks");
	  default: return super.getStockCount(productOptions);
	  }
	}
  
  public void setStockCount(int stockCount, String productOptions)
	{
    // Use the productOptions to check for (and set) the number of stock for "Paperback" etc
   	// Use the variables paperbackStock and hardcoverStock at the top. 
   	// For "EBook", set the inherited stockCount variable.
	  switch (productOptions)
	  {
	  case "Hardcover": this.hardcoverStock = stockCount; break;
	  case "Paperback": this.paperbackStock = stockCount; break;
	  case "Ebook": this.setStockCount(stockCount, productOptions); break;
	  }
	}
  
  /*
   * When a book is ordered, reduce the stock count for the specific stock type
   */
  public void reduceStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and reduce) the number of stock for "Paperback" etc
   	// Use the variables paperbackStock and hardcoverStock at the top. 
   	// For "EBook", set the inherited stockCount variable.
	  switch (productOptions)
	  {
	  case "Hardcover": hardcoverStock--; break;
	  case "Paperback": paperbackStock--; break;
	  case "Ebook": super.reduceStockCount(productOptions); break;
	  }
	}
  /*
   * Print product information in super class and append Book specific information title and author
   */
  public void print()
  {
  	// Replace the line below.
  	// Make use of the super class print() method and append the title and author info. See the video
  	super.print();
    System.out.print(" Book Title: " + title + " Author: " + author + " Year: " + year);
  }
}
