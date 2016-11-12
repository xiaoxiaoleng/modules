package org.iac.module.extension.test.mail;

import com.icegreen.greenmail.util.GreenMail;
import org.iac.module.core.test.spring.SpringContextTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = {"/applicationContext-mail.xml"})
public class MailServerSimulatorTest extends SpringContextTestCase {

    @Autowired
    private GreenMail greenMail;

    @Test
    public void greenMail() {
        assertThat(greenMail.getSmtp().getPort()).isEqualTo(3025);
    }
}
