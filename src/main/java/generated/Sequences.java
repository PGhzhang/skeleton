/**
 * This class is generated by jOOQ
 */
package generated;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in public
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

	/**
	 * The sequence <code>public.system_sequence_3af6b12a_d204_42a0_8f99_2a662e29e2a9</code>
	 */
	public static final Sequence<Long> SYSTEM_SEQUENCE_3AF6B12A_D204_42A0_8F99_2A662E29E2A9 = new SequenceImpl<Long>("system_sequence_3af6b12a_d204_42a0_8f99_2a662e29e2a9", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);

	/**
	 * The sequence <code>public.system_sequence_df3d782b_b021_497d_af79_7685ffd99744</code>
	 */
	public static final Sequence<Long> SYSTEM_SEQUENCE_DF3D782B_B021_497D_AF79_7685FFD99744 = new SequenceImpl<Long>("system_sequence_df3d782b_b021_497d_af79_7685ffd99744", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);
}
