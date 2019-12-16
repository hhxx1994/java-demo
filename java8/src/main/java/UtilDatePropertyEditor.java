import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDatePropertyEditor extends PropertyEditorSupport {
    private String formate;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formate);
        try {
            Date date = simpleDateFormat.parse(text);
            this.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setFormate(String formate) {
        this.formate = formate;
    }

}