import javax.swing.*;
import java.awt.*;

public class SimplePuyo extends JPanel {
    private int puyoY = 0; // 上からの縦位置
    private final int puyoX = 100; // 横位置の固定
    private final int puyoSize = 40; // ぷよの大きさ
    private final int groundY = 460; // ぷよが止まる画面下端
    private boolean isFalling = true; // 落下中フラグ

    public SimplePuyo() {
        // 50ミリ秒ごとに画面を更新
        Timer timer = new Timer(50, e -> {
            if (isFalling) {
                puyoY += 5; // 下に落ちる
                if (puyoY >= groundY - puyoSize) {
                    puyoY = groundY - puyoSize; // 床に揃える
                    isFalling = false; // 落下終了
                }
            }
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
        // 地面の線
        g.setColor(Color.GRAY);
        g.fillRect(0, groundY, getWidth(), 10);
        // 赤ぷよの描画
        g.setColor(Color.RED);
        g.fillOval(puyoX, puyoY, puyoSize, puyoSize);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ぷよぷよ練習 下で止まるver.");
        SimplePuyo panel = new SimplePuyo();
        frame.add(panel);
        frame.setSize(300, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}