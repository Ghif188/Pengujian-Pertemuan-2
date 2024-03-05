import org.example.Tugas.Wallet;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WalletTest {
    public ArrayList<Wallet> listdompet;
    @BeforeAll
    public void inisitializeClass(){
        listdompet = new ArrayList<>();
    }
    @BeforeEach
    public void inisitializeMethod(){
        Wallet dompet1 = new Wallet("Ghifari");
        Wallet dompet2 = new Wallet("Indri");
        listdompet.add(dompet1);
        listdompet.add(dompet2);
    }
    @AfterEach
    public void cleanMethod(){
        listdompet.clear();
    }
    @AfterAll
    public void cleanClass(){
        listdompet.clear();
    }

    @Test
    public void testDataCreation(){
        Assertions.assertTrue(!listdompet.isEmpty());
    }
    @Test
    public void testWalletOwner(){
        listdompet.get(0).setOwner("Askar");
        Assertions.assertSame("Askar", listdompet.get(0).getOwner());
    }

    @Test
    public void testCardWallet(){
        listdompet.get(0).addCard("BNI");
        listdompet.get(0).addCard("BRI");
        listdompet.get(0).takeCard("BNI");
        List<String> kartu = new ArrayList<>();
        kartu.add("BRI");
        Assertions.assertEquals(kartu, listdompet.get(0).getCards());
    }

    @Test
    public void testMoneyWallet(){
        listdompet.get(0).addMoney(10000);
        listdompet.get(0).addMoney(1000);
        listdompet.get(0).addMoney(20000);
        listdompet.get(0).takeMoneys(20000);
        Assertions.assertEquals(11000, listdompet.get(0).calculateMoneys());
        Assertions.assertSame(1, listdompet.get(0).getMoneys().get(1000));
    }

    @Test
    public void testCoinWallet(){
        listdompet.get(0).addCoin(100);
        listdompet.get(0).addCoin(200);
        listdompet.get(0).addCoin(200);
        listdompet.get(0).takeCoins(100);
        Assertions.assertEquals(400, listdompet.get(0).calculateCoins());
        Assertions.assertSame(2, listdompet.get(0).getCoins().get(200));
    }

    @Test
    public void testMoneyAvailable(){
        listdompet.get(0).addCoin(100);
        listdompet.get(0).addCoin(100);
        listdompet.get(0).addMoney(1000);
        listdompet.get(0).addMoney(10000);
        listdompet.get(0).takeMoneys(1000);
        listdompet.get(0).takeCoins(100);
        Assertions.assertEquals(10100, listdompet.get(0).getMoneyAvailable());
    }
}
