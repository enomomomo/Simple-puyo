import javax.swing.*;
import java.awt.*;

public class SimplePuyo extends JPanel {
    private int puyoY = 0; // 上からの縦位置
    private final int puyoX = 100; // 横位置の固定
    private final int puyoSize = 40; // ぷよの大きさ

    public SimplePuyo() {
        // 50ミリ秒ごとに画面を更新（仮）
        Timer timer = new Timer(50, e -> {
            puyoY += 5; // 下に落ちる
            repaint(); // 再描画
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 背景を白にする
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        // 赤ぷよを描画する
        g.setColor(Color.RED);
        g.fillOval(puyoX, puyoY, puyoSize, puyoSize);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ぷよぷよ練習 1個落とすver.");
        SimplePuyo panel = new SimplePuyo();
        frame.add(panel);
        frame.setSize(300, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}