package dao;

import api.ReceiptResponse;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.TagsRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;


import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;
import static generated.Tables.RECEIPTS;
import static generated.Tables.TAGS;

public class TagDao {

    DSLContext dsl;

    public TagDao(Configuration jooqConfig) {

        this.dsl = DSL.using(jooqConfig);
    }

    public int insert(String tagName, Integer receiptId) {
        TagsRecord tagsRecord = dsl
                .insertInto(TAGS, TAGS.NAME, TAGS.RECEIPTID)
                .values(tagName,receiptId)
                .returning(TAGS.ID)
                .fetchOne();

        checkState(tagsRecord != null && tagsRecord.getId() != null, "Insert tags failed");

        System.out.println("tagID after insertion is " + tagsRecord.getId());
        return tagsRecord.getId();
    }

    public boolean tagged(String tagName, Integer receiptId) {

        List<Integer> TaggedReceipts = dsl.selectFrom(TAGS)
                .where(TAGS.RECEIPTID.eq(receiptId))
                .and(TAGS.NAME.eq(tagName))
                .fetch(TAGS.ID);

        return  (TaggedReceipts.size()>=1);
    }


    public void untag(String tagName, Integer receiptId){
        dsl.deleteFrom(TAGS)
                .where(TAGS.RECEIPTID.eq(receiptId))
                .and(TAGS.NAME.eq(tagName))
                .execute();
    }

    public List<ReceiptsRecord> getAllReceiptsForTag(String tagName) {
        return dsl.select()
                .from(RECEIPTS)
                .join(TAGS)
                .on(TAGS.RECEIPTID.eq(RECEIPTS.ID))
                .where(TAGS.NAME.eq(tagName))
                .fetchInto(RECEIPTS);
    }

}





