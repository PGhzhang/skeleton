package api;


import generated.tables.records.ReceiptsRecord;
import io.dropwizard.jersey.validation.Validators;
import org.junit.Test;
import org.junit.Before;

import javax.validation.Validator;
import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;



public class TagResponseTest {

    private final Validator validator = Validators.newValidator();


    @Test
    public void testMissingInfo(){
        TagResponse tag = new TagResponse(new ReceiptsRecord());
        validator.validate(tag);
        assertThat(validator.validate(tag), hasSize(1));

    }
}