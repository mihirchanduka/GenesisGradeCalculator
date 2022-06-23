package GenesisGradeCalculator;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class GenesisScraper implements ActionListener {
    private static Document html;

    public static String[] ScrapeClasses(Document html){
        Document doc = Jsoup.parseBodyFragment(String.valueOf(html));
        Elements classes = doc.select("u");
        int i = 0;
        String[] s = new String[classes.size()];
        for(Element el : classes){
            s[i++] = el.html();
        }
        return s;
    }

    public static String[] ScrapeGrades(Document html){
        Document doc = Jsoup.parseBodyFragment(String.valueOf(html));
        doc.getElementsByTag("span").remove();
        Elements tr = doc.getElementsByAttributeValue("style", "text-decoration: underline");
        int i = 0;
        String[] s = new String[tr.size()];
        for(Element el : tr){
            s[i++] = el.html();
        }
        return s;
    }

    public static String[] ScrapeLetterGrade(Document html){
        Document doc = Jsoup.parseBodyFragment(String.valueOf(html));
        Elements classes = doc.getElementsByAttributeValue("style", "border:0;");
        int i = 0;
        String[] s = new String[classes.size()];
        for(Element el : classes){
            s[i++] = el.html();
        }
        return s;
    }

    private static Document Login(String username, String password, int studentID, int markingperiod) throws IOException {

        Connection.Response loginForm = Jsoup.connect("https://parents.edison.k12.nj.us/genesis/sis/view?gohome=true")
                .method(Connection.Method.GET)
                .execute();

        Document document = Jsoup.connect("https://parents.edison.k12.nj.us/genesis/sis/j_security_check")
                .data("j_username", username)
                .data("j_password", password)
                .cookies(loginForm.cookies())
                .followRedirects(true)
                .post();
        String gradebookurl = "https://parents.edison.k12.nj.us/genesis/parents?tab1=studentdata&tab2=gradebook&tab3=weeklysummary&studentid=" + studentID + "&action=form&mpToView=MP" + markingperiod;
        Document gradebook = Jsoup.connect(gradebookurl)
                .cookies(loginForm.cookies())
                .get();
        return gradebook;


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            html = (Login(LoginPage.userText.getText(), LoginPage.passwordText.getText(), Integer.parseInt(LoginPage.studentIDText.getText()), Integer.parseInt(LoginPage.MKText.getText())));
            LoginPage.frame.setVisible(false);
            new Gradebook(ScrapeClasses(html), ScrapeGrades(html), ScrapeLetterGrade(html));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
