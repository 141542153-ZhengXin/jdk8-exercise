import com.geek.optional.OptionalDTO;
import com.geek.optional.OptionalUtil;
import org.junit.Test;

import java.util.Optional;

/**
 * @version V1.0
 * @description: OptionalTx
 * @author: geek
 * @date 2022/10/16
 **/
public class OptionalTx {

    @Test
    public void empty() {
        Optional<OptionalDTO> emptyOp = Optional.empty();
        OptionalUtil.empty(emptyOp);
        emptyOp = Optional.ofNullable(null);
        OptionalUtil.empty(emptyOp);
    }

    @Test
    public void of() {
        final Optional<OptionalDTO> noEmptyOp = Optional.of(OptionalDTO.builder().id("1").name("optional").content("hello").build());
        OptionalUtil.of(noEmptyOp);

        final Optional emptyOp = null;
        OptionalUtil.of(emptyOp);
    }

    @Test
    public void ofNullable() {
        final Optional<OptionalDTO> noEmptyOp = Optional.of(OptionalDTO.builder().id("1").name("optional").content("hello").build());
        OptionalUtil.ofNullable(noEmptyOp);
    }

    @Test
    public void ifPresent() {
        final Optional<OptionalDTO> noEmptyOp = Optional.of(OptionalDTO.builder().id("1").name("optional").content("hello").build());
        OptionalUtil.ifPresent(noEmptyOp);
    }

    @Test
    public void map() {
        final Optional<OptionalDTO> noEmptyOp = Optional.of(OptionalDTO.builder().id("1").name("optional").content("hello").build());
        OptionalUtil.map(noEmptyOp);
    }

    @Test
    public void filter() {
        final Optional<OptionalDTO> noEmptyOp = Optional.of(OptionalDTO.builder().id("1").name("optional").content("hello").build());
        OptionalUtil.filter(noEmptyOp);
    }
}
