import model.dao.BusinessDAO;
import model.entity.Business;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
//Tests for CRUD
public class BusinessTest {
    @Test public void TestCreate() throws SQLException {
        BusinessDAO dao = new BusinessDAO();
        Business b = new Business();
        b.setName("Test");
        b.setType("example");
        dao.create(b);
        Business found = dao.read(b.getId());
        assertAll(
                ()-> assertNotNull(b.getId()),
                ()-> assertEquals(found.getType(), b.getType())
        );
        dao.delete(b);
    }

    @Test public void TestRead() throws SQLException {
        BusinessDAO dao = new BusinessDAO();
        Business b = new Business();
        b.setName("Test");
        b.setType("example");
        b.setAddress("1111 Example Drive 99999");
        b.setProfit(100F);
        dao.create(b);
        Business found = dao.read(b.getId());
        assertAll(
                ()-> assertEquals(b.getId(), found.getId()),
                ()-> assertEquals("Test", b.getName()),
                ()-> assertEquals("example", b.getType()),
                ()-> assertEquals("1111 Example Drive 99999", b.getAddress()),
                ()-> assertEquals(100F, b.getProfit())
        );
        dao.delete(b);
    }
    @Test public void TestUpdate() throws SQLException {
        BusinessDAO dao = new BusinessDAO();
        Business b = new Business();
        b.setName("Test");
        dao.create(b);
        Business found = dao.read(b.getId());
        assertAll(
                ()-> assertEquals("Test", found.getName()),
                ()-> assertNotNull(b.getName())
        );
        dao.delete(b);
    }
    @Test public void TestDelete() throws SQLException {
        BusinessDAO dao = new BusinessDAO();
        Business b = new Business();
        b.setName("Test");
        dao.create(b);
        Business found = dao.read(b.getId());
        dao.delete(b);
        assertAll(
                ()-> assertNotNull(found.getId()),
                ()-> assertNull(dao.read(b.getId()))
        );
    }
}
