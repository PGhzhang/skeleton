package api;


import generated.tables.records.ReceiptsRecord;
import io.dropwizard.jersey.validation.Validators;
import org.junit.Test;

import javax.validation.Validator;
import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;



public class TagResponseTest {

    private final Validator validator = Validators.newValidator();
    private ReceiptsRecord record;

    @Test
    public void testValid() {
        TagResponse trecord = new TagResponse(record);

        assertThat(validator.validate(trecord), empty());
    }
}