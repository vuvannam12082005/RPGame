package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // window set up
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close on exit
        window.setResizable(false); // fixed size
        window.setTitle("HIEP SI ONLINE"); // game title
        window.setLocationRelativeTo(null);
   
        
        Gamepanel gamepanel = new Gamepanel();
        window.add(gamepanel);
        window.pack();
        window.setLocationRelativeTo(null); // đặt giữa màn hình
        gamepanel.setupGame(); // Khởi tạo các đối tượng game trước
        gamepanel.startgamethread(); // Bắt đầu game loop
        window.setVisible(true);
    }
}
