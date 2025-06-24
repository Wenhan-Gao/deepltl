package owl.run;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import owl.run.modules.InputReader;
import owl.run.modules.OutputWriter;
import owl.run.modules.Transformer;

/**
 * Immutable implementation of {@link Pipeline}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePipeline.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code ImmutablePipeline.of()}.
 */
@SuppressWarnings({"all"})
@SuppressFBWarnings
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Pipeline"})
@Immutable
@CheckReturnValue
public final class ImmutablePipeline extends Pipeline {
  private final InputReader input;
  private final OutputWriter output;
  private final ImmutableList<Transformer> transformers;

  private ImmutablePipeline(
      InputReader input,
      OutputWriter output,
      Iterable<? extends Transformer> transformers) {
    this.input = Objects.requireNonNull(input, "input");
    this.output = Objects.requireNonNull(output, "output");
    this.transformers = ImmutableList.copyOf(transformers);
  }

  private ImmutablePipeline(
      ImmutablePipeline original,
      InputReader input,
      OutputWriter output,
      ImmutableList<Transformer> transformers) {
    this.input = input;
    this.output = output;
    this.transformers = transformers;
  }

  /**
   * @return The value of the {@code input} attribute
   */
  @Override
  public InputReader input() {
    return input;
  }

  /**
   * @return The value of the {@code output} attribute
   */
  @Override
  public OutputWriter output() {
    return output;
  }

  /**
   * @return The value of the {@code transformers} attribute
   */
  @Override
  public ImmutableList<Transformer> transformers() {
    return transformers;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Pipeline#input() input} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for input
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePipeline withInput(InputReader value) {
    if (this.input == value) return this;
    InputReader newValue = Objects.requireNonNull(value, "input");
    return new ImmutablePipeline(this, newValue, this.output, this.transformers);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Pipeline#output() output} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for output
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePipeline withOutput(OutputWriter value) {
    if (this.output == value) return this;
    OutputWriter newValue = Objects.requireNonNull(value, "output");
    return new ImmutablePipeline(this, this.input, newValue, this.transformers);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Pipeline#transformers() transformers}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePipeline withTransformers(Transformer... elements) {
    ImmutableList<Transformer> newValue = ImmutableList.copyOf(elements);
    return new ImmutablePipeline(this, this.input, this.output, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Pipeline#transformers() transformers}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of transformers elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePipeline withTransformers(Iterable<? extends Transformer> elements) {
    if (this.transformers == elements) return this;
    ImmutableList<Transformer> newValue = ImmutableList.copyOf(elements);
    return new ImmutablePipeline(this, this.input, this.output, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePipeline} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePipeline
        && equalTo((ImmutablePipeline) another);
  }

  private boolean equalTo(ImmutablePipeline another) {
    return input.equals(another.input)
        && output.equals(another.output)
        && transformers.equals(another.transformers);
  }

  /**
   * Computes a hash code from attributes: {@code input}, {@code output}, {@code transformers}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + input.hashCode();
    h += (h << 5) + output.hashCode();
    h += (h << 5) + transformers.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Pipeline} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Pipeline")
        .omitNullValues()
        .add("input", input)
        .add("output", output)
        .add("transformers", transformers)
        .toString();
  }

  /**
   * Construct a new immutable {@code Pipeline} instance.
   * @param input The value for the {@code input} attribute
   * @param output The value for the {@code output} attribute
   * @param transformers The value for the {@code transformers} attribute
   * @return An immutable Pipeline instance
   */
  public static ImmutablePipeline of(InputReader input, OutputWriter output, List<Transformer> transformers) {
    return of(input, output, (Iterable<? extends Transformer>) transformers);
  }

  /**
   * Construct a new immutable {@code Pipeline} instance.
   * @param input The value for the {@code input} attribute
   * @param output The value for the {@code output} attribute
   * @param transformers The value for the {@code transformers} attribute
   * @return An immutable Pipeline instance
   */
  public static ImmutablePipeline of(InputReader input, OutputWriter output, Iterable<? extends Transformer> transformers) {
    return new ImmutablePipeline(input, output, transformers);
  }

  /**
   * Creates an immutable copy of a {@link Pipeline} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Pipeline instance
   */
  public static ImmutablePipeline copyOf(Pipeline instance) {
    if (instance instanceof ImmutablePipeline) {
      return (ImmutablePipeline) instance;
    }
    return ImmutablePipeline.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePipeline ImmutablePipeline}.
   * @return A new ImmutablePipeline builder
   */
  public static ImmutablePipeline.Builder builder() {
    return new ImmutablePipeline.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePipeline ImmutablePipeline}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_INPUT = 0x1L;
    private static final long INIT_BIT_OUTPUT = 0x2L;
    private long initBits = 0x3L;

    private @Nullable InputReader input;
    private @Nullable OutputWriter output;
    private ImmutableList.Builder<Transformer> transformers = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Pipeline} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Pipeline instance) {
      Objects.requireNonNull(instance, "instance");
      input(instance.input());
      output(instance.output());
      addAllTransformers(instance.transformers());
      return this;
    }

    /**
     * Initializes the value for the {@link Pipeline#input() input} attribute.
     * @param input The value for input 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder input(InputReader input) {
      this.input = Objects.requireNonNull(input, "input");
      initBits &= ~INIT_BIT_INPUT;
      return this;
    }

    /**
     * Initializes the value for the {@link Pipeline#output() output} attribute.
     * @param output The value for output 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder output(OutputWriter output) {
      this.output = Objects.requireNonNull(output, "output");
      initBits &= ~INIT_BIT_OUTPUT;
      return this;
    }

    /**
     * Adds one element to {@link Pipeline#transformers() transformers} list.
     * @param element A transformers element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addTransformers(Transformer element) {
      this.transformers.add(element);
      return this;
    }

    /**
     * Adds elements to {@link Pipeline#transformers() transformers} list.
     * @param elements An array of transformers elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addTransformers(Transformer... elements) {
      this.transformers.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link Pipeline#transformers() transformers} list.
     * @param elements An iterable of transformers elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder transformers(Iterable<? extends Transformer> elements) {
      this.transformers = ImmutableList.builder();
      return addAllTransformers(elements);
    }

    /**
     * Adds elements to {@link Pipeline#transformers() transformers} list.
     * @param elements An iterable of transformers elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllTransformers(Iterable<? extends Transformer> elements) {
      this.transformers.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutablePipeline ImmutablePipeline}.
     * @return An immutable instance of Pipeline
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePipeline build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePipeline(null, input, output, transformers.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_INPUT) != 0) attributes.add("input");
      if ((initBits & INIT_BIT_OUTPUT) != 0) attributes.add("output");
      return "Cannot build Pipeline, some of required attributes are not set " + attributes;
    }
  }
}
