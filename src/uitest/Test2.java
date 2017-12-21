package uitest;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import com.user.UserBiz;
import com.vo.Item;
import com.vo.User;
 
 

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Array;
import java.util.ArrayList;
 
import com.user.UserBiz;
import com.vo.Item;
import com.vo.User;
 
public class Test2 extends WindowAdapter implements ActionListener {
    UserBiz biz;
    Frame frame;
    Panel mainp, mainp2, p1, p2;
    List list;
 
    Button b1, b2, b3, b4, b5;
    Label lb1, lb2, lb3, lb4, lb5, elb, blb;
 
    TextField tf1, tf2, tf3, tf4, tf5;
 
    public Test2() {
        makeUi();
        biz = new UserBiz();
    }
 
    public void makeUi() {
        frame = new Frame();
        frame.addWindowListener(this);
        mainp = new Panel();
        p1 = new Panel();
        list = new List();
 
        b1 = new Button("입력");
        b2 = new Button("수정");
        b3 = new Button("삭제");
        b4 = new Button("조회");
        b5 = new Button("상세 조회");
 
        lb1 = new Label("ID");
        lb2 = new Label("PWD");
        lb3 = new Label("NAME");
        lb4 = new Label("ITEM_NAME");
        lb5 = new Label("PRICE");
        blb = new Label(" ");
        elb = new Label("STATUS");
 
        tf1 = new TextField(10);
        tf2 = new TextField(10);
        tf3 = new TextField(10);
        tf4 = new TextField(10);
        tf5 = new TextField(10);
 
        //GridLayout parameter
        //1) 행 2) 열 3) 좌우간격(열과 열사이 간격) 4) 상하간격(행과 행사이 간격)        
        // 1,1 -> 1, 2 -> 1, 3 -> 2, 1 -> 2, 2 .... 으로 add 된다. 
        p1.setLayout(new GridLayout(5, 3, 15, 5));
        p1.add(lb1); p1.add(tf1); p1.add(b1);
        p1.add(lb2); p1.add(tf2); p1.add(b2);
        p1.add(lb3); p1.add(tf3); p1.add(b3);
        p1.add(lb4); p1.add(tf4); p1.add(b4);
        p1.add(lb5); p1.add(tf5); p1.add(b5);
 
        mainp.setLayout(new GridLayout(1, 1));
        mainp.add(p1);
        mainp.setBackground(Color.gray);
        frame.add(mainp, "North");
        frame.add(list, "Center");
        frame.add(elb, "South");
 
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
 
        frame.setBounds(30, 30, 200, 200);
        frame.setSize(500, 300);
        frame.setVisible(true);
 
        list.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // elb.setText(e.getItem().toString()+"");
                int index = (int) e.getItem();
                String text = list.getItem(index);
                elb.setText(text);
            }
        });
 
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)) { // 입력
            addUser();
        } else if (e.getSource().equals(b2)) { // 수정
            updateUser();
        } else if (e.getSource().equals(b3)) { // 삭제
            deleteUser();
        } else if (e.getSource().equals(b4)) { // 조회
            getUser();
        } else if (e.getSource().equals(b5)) { // 전체조회
            getUserAll();
        }
    }
 
    private void addUser() {
        String id = tf1.getText();
        String pwd = tf2.getText();
        String name = tf3.getText();
        String itemName = tf4.getText();
        int price = Integer.parseInt(tf5.getText());
        User user = new User(id, pwd, name);
        Item item = new Item(id, itemName, price);
        user.setItem(item);
 
        try {
            biz.register(user);
            elb.setText("입력성공");
            getUser();
        } catch (Exception e) {
            elb.setText("입력오류");
            e.printStackTrace();
        }
    }
 
    private void getUserAll() {
        ArrayList<Object> userList = null;
        list.removeAll();
        try {
            userList = biz.get();
            for (Object obj : userList) {
                User u = (User) obj;
                Item item = u.getItem();
                String text = u.getId() + " " + u.getPwd() + " " + u.getName() + " " + item.getName() + " "
                        + item.getPrice() + " " + item.getRegdate();
                list.add(text);
            }
            elb.setText("상세 조회 성공");
        } catch (Exception e) {
            elb.setText("상세 조회 오류");
            e.printStackTrace();
        }
    }
 
    private void getUser() {
        User user = null;
        Item item = null;
        String id = tf1.getText();
        list.removeAll();
        try {
            user = (User) biz.get(id);
            item = user.getItem();
            String text = user.getId() + " " + user.getPwd() + " " + user.getName() + " " + item.getName() + " "
                    + item.getPrice() + " " + item.getRegdate();
            list.add(text);
            elb.setText("조회 성공");
 
        } catch (Exception e) {
            elb.setText("조회 오류");
            e.printStackTrace();
        }
    }
 
    private void deleteUser() {
        int index = list.getSelectedIndex();
        String text = list.getItem(index).trim();             // trim 문자열의 앞뒤 공란제거  
        String id = text.substring(0, text.indexOf(" "));    //substring 0 ~ 부터 " " 공란까지
        try {
            biz.remove(id);
            elb.setText("삭제 성공");
            list.remove(index);
        } catch (Exception e) {
            elb.setText("삭제 오류");
            e.printStackTrace();
        }
    }
 
    private void updateUser() {
        String id = tf1.getText();
        String pwd = tf2.getText();
        String name = tf3.getText();
        String itemName = tf4.getText();
        int price = Integer.parseInt(tf5.getText());
 
        User user = new User(id, pwd, name);
        Item item = new Item(id, itemName, price);
        user.setItem(item);
 
        try {
            biz.modify(user);
            elb.setText("수정 성공");
            getUser();
        } catch (Exception e) {
            elb.setText("수정 시 오류");
            e.printStackTrace();
        }
 
    }
 
    @Override
    public void windowClosing(WindowEvent arg0) {
        super.windowClosing(arg0);
        frame.setVisible(false);
        frame.dispose();
    }
 
}



