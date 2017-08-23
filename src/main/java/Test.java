import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.HibernateUtil;

import entity.Bid;
import entity.Category;
import entity.Item;


public class Test {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Item item = new Item(106L, "phone", new Date(), new BigDecimal(20), new Date(), new Date());
		
		Bid bid = new Bid(104L,new BigDecimal(20), new  Date(),item);
		
		Category category = new Category("Books",new Date(),new HashSet<String>(Arrays.asList(new String[]{"Books","Java Books","Programming"})));
		
		HashSet<Category> categories = new HashSet<Category>();
		
		HashSet<Item> items = new HashSet<Item>();
		
		items.add(item);
		
		category.setItems(items);
		
		Transaction transaction = session.getTransaction();

		transaction.begin();
		
		item.setCategories(categories);

		session.save(item);
		
		session.save(bid);

		transaction.commit();

		session.close();

		sessionFactory.close();

	}

}
