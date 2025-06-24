package owl.run.parser;

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

/**
 * Builds instances of type {@link PartialModuleConfiguration PartialModuleConfiguration}.
 * Initialize attributes and then invoke the {@link #build()} method to create an
 * immutable instance.
 * <p><em>{@code PartialModuleConfigurationBuilder} is not thread-safe and generally should not be stored in a field or collection,
 * but instead used immediately to create instances.</em>
 */
@SuppressWarnings({"all"})
@SuppressFBWarnings
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "PartialModuleConfiguration"})
@NotThreadSafe
final class PartialModuleConfigurationBuilder {
  private static final long INIT_BIT_INPUT = 0x1L;
  private static final long INIT_BIT_OUTPUT = 0x2L;
  private static final long INIT_BIT_NAME = 0x4L;
  private long initBits = 0x7L;

  private @Nullable Wrapper input;
  private ImmutableList.Builder<Wrapper> transformers = ImmutableList.builder();
  private @Nullable Wrapper output;
  private @Nullable String name;

  /**
   * Creates a builder for {@link PartialModuleConfiguration PartialModuleConfiguration} instances.
   */
  PartialModuleConfigurationBuilder() {
  }

  /**
   * Fill a builder with attribute values from the provided {@code PartialModuleConfiguration} instance.
   * Regular attribute values will be replaced with those from the given instance.
   * Absent optional values will not replace present values.
   * Collection elements and entries will be added, not replaced.
   * @param instance The instance from which to copy values
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final PartialModuleConfigurationBuilder from(PartialModuleConfiguration instance) {
    Objects.requireNonNull(instance, "instance");
    input(instance.input());
    addAllTransformers(instance.transformers());
    output(instance.output());
    name(instance.name());
    return this;
  }

  /**
   * Initializes the value for the {@link PartialModuleConfiguration#input() input} attribute.
   * @param input The value for input 
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final PartialModuleConfigurationBuilder input(Wrapper input) {
    this.input = Objects.requireNonNull(input, "input");
    initBits &= ~INIT_BIT_INPUT;
    return this;
  }

  /**
   * Adds one element to {@link PartialModuleConfiguration#transformers() transformers} list.
   * @param element A transformers element
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final PartialModuleConfigurationBuilder addTransformers(Wrapper element) {
    this.transformers.add(element);
    return this;
  }

  /**
   * Adds elements to {@link PartialModuleConfiguration#transformers() transformers} list.
   * @param elements An array of transformers elements
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final PartialModuleConfigurationBuilder addTransformers(Wrapper... elements) {
    this.transformers.add(elements);
    return this;
  }

  /**
   * Sets or replaces all elements for {@link PartialModuleConfiguration#transformers() transformers} list.
   * @param elements An iterable of transformers elements
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final PartialModuleConfigurationBuilder transformers(Iterable<? extends Wrapper> elements) {
    this.transformers = ImmutableList.builder();
    return addAllTransformers(elements);
  }

  /**
   * Adds elements to {@link PartialModuleConfiguration#transformers() transformers} list.
   * @param elements An iterable of transformers elements
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final PartialModuleConfigurationBuilder addAllTransformers(Iterable<? extends Wrapper> elements) {
    this.transformers.addAll(elements);
    return this;
  }

  /**
   * Initializes the value for the {@link PartialModuleConfiguration#output() output} attribute.
   * @param output The value for output 
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final PartialModuleConfigurationBuilder output(Wrapper output) {
    this.output = Objects.requireNonNull(output, "output");
    initBits &= ~INIT_BIT_OUTPUT;
    return this;
  }

  /**
   * Initializes the value for the {@link PartialModuleConfiguration#name() name} attribute.
   * @param name The value for name 
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final PartialModuleConfigurationBuilder name(String name) {
    this.name = Objects.requireNonNull(name, "name");
    initBits &= ~INIT_BIT_NAME;
    return this;
  }

  /**
   * Builds a new {@link PartialModuleConfiguration PartialModuleConfiguration}.
   * @return An immutable instance of PartialModuleConfiguration
   * @throws java.lang.IllegalStateException if any required attributes are missing
   */
  public PartialModuleConfiguration build() {
    if (initBits != 0) {
      throw new IllegalStateException(formatRequiredAttributesMessage());
    }
    return new PartialModuleConfigurationBuilder.ImmutablePartialModuleConfiguration(this);
  }

  private String formatRequiredAttributesMessage() {
    List<String> attributes = Lists.newArrayList();
    if ((initBits & INIT_BIT_INPUT) != 0) attributes.add("input");
    if ((initBits & INIT_BIT_OUTPUT) != 0) attributes.add("output");
    if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
    return "Cannot build PartialModuleConfiguration, some of required attributes are not set " + attributes;
  }

  /**
   * Immutable implementation of {@link PartialModuleConfiguration}.
   * <p>
   * Use the builder to create immutable instances:
   * {@code new PartialModuleConfigurationBuilder()}.
   */
  @Immutable
  @CheckReturnValue
  private static final class ImmutablePartialModuleConfiguration extends PartialModuleConfiguration {
    private final Wrapper input;
    private final ImmutableList<Wrapper> transformers;
    private final Wrapper output;
    private final String name;

    private ImmutablePartialModuleConfiguration(PartialModuleConfigurationBuilder builder) {
      this.input = builder.input;
      this.transformers = builder.transformers.build();
      this.output = builder.output;
      this.name = builder.name;
    }

    /**
     * @return The value of the {@code input} attribute
     */
    @Override
    Wrapper input() {
      return input;
    }

    /**
     * @return The value of the {@code transformers} attribute
     */
    @Override
    ImmutableList<Wrapper> transformers() {
      return transformers;
    }

    /**
     * @return The value of the {@code output} attribute
     */
    @Override
    Wrapper output() {
      return output;
    }

    /**
     * @return The value of the {@code name} attribute
     */
    @Override
    String name() {
      return name;
    }

    /**
     * This instance is equal to all instances of {@code ImmutablePartialModuleConfiguration} that have equal attribute values.
     * @return {@code true} if {@code this} is equal to {@code another} instance
     */
    @Override
    public boolean equals(@Nullable Object another) {
      if (this == another) return true;
      return another instanceof PartialModuleConfigurationBuilder.ImmutablePartialModuleConfiguration
          && equalTo((PartialModuleConfigurationBuilder.ImmutablePartialModuleConfiguration) another);
    }

    private boolean equalTo(PartialModuleConfigurationBuilder.ImmutablePartialModuleConfiguration another) {
      return input.equals(another.input)
          && transformers.equals(another.transformers)
          && output.equals(another.output)
          && name.equals(another.name);
    }

    /**
     * Computes a hash code from attributes: {@code input}, {@code transformers}, {@code output}, {@code name}.
     * @return hashCode value
     */
    @Override
    public int hashCode() {
      int h = 5381;
      h += (h << 5) + input.hashCode();
      h += (h << 5) + transformers.hashCode();
      h += (h << 5) + output.hashCode();
      h += (h << 5) + name.hashCode();
      return h;
    }

    /**
     * Prints the immutable value {@code PartialModuleConfiguration} with attribute values.
     * @return A string representation of the value
     */
    @Override
    public String toString() {
      return MoreObjects.toStringHelper("PartialModuleConfiguration")
          .omitNullValues()
          .add("input", input)
          .add("transformers", transformers)
          .add("output", output)
          .add("name", name)
          .toString();
    }
  }
}
