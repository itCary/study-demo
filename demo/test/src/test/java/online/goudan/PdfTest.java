package online.goudan;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenglongliu
 * @date 2021/4/13 10:51
 * @desc pdf转图片
 */
public class PdfTest {
    private String pdfPath;

    @Before
    public void init() throws FileNotFoundException {
        pdfPath = "/Users/Cary/Downloads/第一行代码——Android.pdf";
    }

    @Test
    public void testPdf2Image() throws IOException {

        pdf2Image(pdfPath);

    }

    /**
     * dpi越大转换后越清晰，相对转换速度越慢
     */
    private static final Integer DPI = 100;

    /**
     * 转换后的图片类型
     */
    private static final String IMG_TYPE = "png";

    /**
     * PDF转图片
     *
     * @param pdfPath PDF文件的
     * @return 图片文件的二进制流
     */
    public static void pdf2Image(String pdfPath) throws IOException {
        File pdfFile = new File(pdfPath);

        PDDocument pdDocument = PDDocument.load(pdfFile);
        PDFRenderer renderer = new PDFRenderer(pdDocument);
        int pages = pdDocument.getPages().getCount();
        for (int i = 0; i < pages; i++) {

            BufferedImage bufferedImage = renderer.renderImageWithDPI(i, 72);
            File output = new File(pdfFile.getParent() + "/" + pdfFile.getName().split("\\.")[0], pdfFile.getName().split("\\.")[0] + i + ".png");
            if (!output.getParentFile().exists()) {
                output.getParentFile().mkdirs();
            }
            ImageIO.write(bufferedImage,
                    "png",
                    output);
            System.out.println(output.getAbsolutePath());
        }
    }

    @Test
    public void test(){
        System.out.println(System.currentTimeMillis());
        Date date = new Date(1618406717462L);
        Date date1 = new Date(1618406882197L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        System.out.println(simpleDateFormat.format(date));
        System.out.println(simpleDateFormat.format(date1));
    }


}
