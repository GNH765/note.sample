
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class Sample {
  private static final String window_title = "メニューバー";
  private static final int locateX = 50;
  private static final int locateY = 50;
  private static final int window_width = 630;
  private static final int window_height = 850;
  private static final int table_width = 630;
  private static final int table_height = 850;
  private static final int row_height = 23;
  private static final String tab = "\t";
  // データ

  Object[] colNames = { "ノート" };
  public static Object rowdata [];
  Object[][] rowData = {
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	      { " "},
	  };

  JTable t = new JTable(this.rowData, this.colNames);
  // 主処理
  public static void main(final String args[]) {

    final Sample sample = new Sample();

  }


  // コンストラクタ
  public Sample() {
    // フレームを作成
    final JFrame f = new JFrame(Sample.window_title);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // メニューバー
    final JMenuBar mb = new JMenuBar();
    final JMenu mFile = new JMenu("ファイル");
    final JMenuItem iSaveAs = new JMenuItem("別名で保存 ...");
    final JMenuItem iExit = new JMenuItem("終了");
    mFile.add(iSaveAs);
    mFile.addSeparator();
    mFile.add(iExit);
    mb.add(mFile);
    f.getRootPane().setJMenuBar(mb);
    // テーブルを追加
    this.t.setRowHeight(Sample.row_height);
    this.t.setGridColor(Color.gray);
    final JScrollPane sp = new JScrollPane();
    sp.getViewport().setView(this.t);
    sp.setPreferredSize(new Dimension(Sample.table_width, Sample.table_height));
    final JPanel p = new JPanel();
    p.add(sp);
    f.getContentPane().add(p, BorderLayout.WEST);
    // フレームを表示
    f.setBounds(Sample.locateX, Sample.locateY, Sample.window_width,
        Sample.window_height);
    f.setVisible(true);
    // 終了クリック時のアクションリスナ
    iExit.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent ae) {
        System.exit(0);
      }
    });
    // 別名で保存クリック時のアクションリスナ
    iSaveAs.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent ae) {
        final JFileChooser fc = new JFileChooser(System
            .getProperty("user.dir"));
        // ダイアログの表示
        final int fd = fc.showSaveDialog(f);
        try {
          if (fd == JFileChooser.APPROVE_OPTION) {
            final FileOutputStream fo = new FileOutputStream(fc
                .getSelectedFile());
            final PrintStream ps = new PrintStream(fo);
            ps.println(Sample.this.t.getValueAt(0, 0)
                + Sample.tab

            		);
            for (int i=0 , countd=1; i<33; i++, countd++) {
            ps.println(Sample.this.t.getValueAt(countd, 0)
                    + Sample.tab);
            }


            ps.close();
            fo.close();
          }
        } catch (final Exception ex) {
        }
      }
    });
  }
}
