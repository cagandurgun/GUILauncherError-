/*
 * Bu kod Çağan Durgun tarafından yazılmıştır.
 */

package hata;

import javax.swing.*;

/**
 * Bu sınıf, hatayı, PopUp olarak ekrana atar.
 * <p>
 * Kullanılacağı projedeki <strong>main()</strong> metotun en
 * altında <strong>{@link GKAileHata#GKA_ÇIKIŞ()}</strong>
 * metotunun kullanılması <strong>şarttır!</strong> Kullanım
 * bilgileri, ilgili metotta açıklanmıştır.
 */
public class GKAileHata extends Exception {

    /**
     * Hata mesajı oluşturmak için constructor.
     */
    public GKAileHata(String message) {
        super(message);
    }

    /**
     * Çıkış protokolü için constructor.
     */
    public GKAileHata() {
        super("");
    }

    /**
     * Kullanıldığı programın düzgün sonlanabilmesi için
     * main metotun içerisinde  bu metot kullanılmalıdır.
     * <p><strong>Kullanımı:</strong>
     * <pre>{@code
     *      public class Main {
     *          public static void main(String[] args) {
     *
     *              new GKAileHata().GKA_ÇIKIŞ();
     *          }
     *      }
     * }</pre>
     * <p>
     * şeklindedir.
     */
    public void GKA_ÇIKIŞ() {
        System.exit(0);
    }

    /**
     * Kullanıcı hatayı görmek isterse.
     */
    @Override
    public void printStackTrace() {
        new GKA(getMessage()).hataPopUp();
    }

    /**
     * Görsel Kullanıcı Arayüzü (GKA)
     */
    private static class GKA extends JFrame {
        private final String mesaj;

        public GKA(String mesaj) {
            this.mesaj = mesaj;
        }

        private void hataPopUp() {
            if (mesaj.isEmpty()) {
                JOptionPane.showMessageDialog(this, mesaj, "Hata Mesajı Yok!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, mesaj, "GKA Hata!", JOptionPane.INFORMATION_MESSAGE);
            }

            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (frame != null) {
                frame.dispose();
            }
        }
    }
}
