import javafx.fxml.FXMLLoader;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class MainAppTest {

    @Test
    public void shouldGetUrl() throws IOException {
        FXMLLoader.load(new File(
                "PersonOverview.fxml"
        ).toURI().toURL());
    }

}
