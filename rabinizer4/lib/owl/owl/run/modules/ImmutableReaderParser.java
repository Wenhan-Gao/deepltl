package owl.run.modules;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

/**
 * Immutable implementation of {@link AbstractOwlModuleParser.AbstractReaderParser}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableReaderParser.builder()}.
 */
@SuppressWarnings({"EmptyClass", "PMD.EmptyMethodInAbstractClassShouldBeAbstract", "all"})
@SuppressFBWarnings
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AbstractOwlModuleParser.AbstractReaderParser"})
@Immutable
@CheckReturnValue
public final class ImmutableReaderParser extends AbstractOwlModuleParser.AbstractReaderParser {
  private final String description;
  private final Options options;
  private final @Nullable Options optionsDirect;
  private final @Nullable Supplier<Options> optionsBuilder;
  private final AbstractOwlModuleParser.ParseFunction<CommandLine, InputReader> parser;
  private final String key;

  private ImmutableReaderParser(ImmutableReaderParser.Builder builder) {
    this.parser = builder.parser;
    this.key = builder.key;
    if (builder.description != null) {
      initShim.description(builder.description);
    }
    if (builder.optionsDirectIsSet()) {
      initShim.optionsDirect(builder.optionsDirect);
    }
    if (builder.optionsBuilderIsSet()) {
      initShim.optionsBuilder(builder.optionsBuilder);
    }
    this.description = initShim.getDescription();
    this.optionsDirect = initShim.optionsDirect();
    this.optionsBuilder = initShim.optionsBuilder();
    this.options = initShim.getOptions();
    this.initShim = null;
  }

  private ImmutableReaderParser(
      String description,
      @Nullable Options optionsDirect,
      @Nullable Supplier<Options> optionsBuilder,
      AbstractOwlModuleParser.ParseFunction<CommandLine, InputReader> parser,
      String key) {
    this.description = description;
    this.optionsDirect = optionsDirect;
    this.optionsBuilder = optionsBuilder;
    this.parser = parser;
    this.key = key;
    initShim.description(this.description);
    initShim.optionsDirect(this.optionsDirect);
    initShim.optionsBuilder(this.optionsBuilder);
    this.options = initShim.getOptions();
    this.initShim = null;
  }

  private static final int STAGE_INITIALIZING = -1;
  private static final int STAGE_UNINITIALIZED = 0;
  private static final int STAGE_INITIALIZED = 1;
  private transient volatile InitShim initShim = new InitShim();

  private final class InitShim {
    private String description;
    private int descriptionBuildStage;

    String getDescription() {
      if (descriptionBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (descriptionBuildStage == STAGE_UNINITIALIZED) {
        descriptionBuildStage = STAGE_INITIALIZING;
        this.description = Objects.requireNonNull(ImmutableReaderParser.super.getDescription(), "description");
        descriptionBuildStage = STAGE_INITIALIZED;
      }
      return this.description;
    }

    void description(String description) {
      this.description = description;
      descriptionBuildStage = STAGE_INITIALIZED;
    }
    private Options options;
    private int optionsBuildStage;

    Options getOptions() {
      if (optionsBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (optionsBuildStage == STAGE_UNINITIALIZED) {
        optionsBuildStage = STAGE_INITIALIZING;
        this.options = Objects.requireNonNull(ImmutableReaderParser.super.getOptions(), "options");
        optionsBuildStage = STAGE_INITIALIZED;
      }
      return this.options;
    }
    private Options optionsDirect;
    private int optionsDirectBuildStage;

    Options optionsDirect() {
      if (optionsDirectBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (optionsDirectBuildStage == STAGE_UNINITIALIZED) {
        optionsDirectBuildStage = STAGE_INITIALIZING;
        this.optionsDirect = ImmutableReaderParser.super.optionsDirect();
        optionsDirectBuildStage = STAGE_INITIALIZED;
      }
      return this.optionsDirect;
    }

    void optionsDirect(Options optionsDirect) {
      this.optionsDirect = optionsDirect;
      optionsDirectBuildStage = STAGE_INITIALIZED;
    }
    private Supplier<Options> optionsBuilder;
    private int optionsBuilderBuildStage;

    Supplier<Options> optionsBuilder() {
      if (optionsBuilderBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (optionsBuilderBuildStage == STAGE_UNINITIALIZED) {
        optionsBuilderBuildStage = STAGE_INITIALIZING;
        this.optionsBuilder = ImmutableReaderParser.super.optionsBuilder();
        optionsBuilderBuildStage = STAGE_INITIALIZED;
      }
      return this.optionsBuilder;
    }

    void optionsBuilder(Supplier<Options> optionsBuilder) {
      this.optionsBuilder = optionsBuilder;
      optionsBuilderBuildStage = STAGE_INITIALIZED;
    }

    private String formatInitCycleMessage() {
      ArrayList<String> attributes = Lists.newArrayList();
      if (descriptionBuildStage == STAGE_INITIALIZING) attributes.add("description");
      if (optionsBuildStage == STAGE_INITIALIZING) attributes.add("options");
      if (optionsDirectBuildStage == STAGE_INITIALIZING) attributes.add("optionsDirect");
      if (optionsBuilderBuildStage == STAGE_INITIALIZING) attributes.add("optionsBuilder");
      return "Cannot build ReaderParser, attribute initializers form cycle" + attributes;
    }
  }

  /**
   * @return The value of the {@code description} attribute
   */
  @Override
  public String getDescription() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.getDescription()
        : this.description;
  }

  /**
   * @return The computed-at-construction value of the {@code options} attribute
   */
  @Override
  public Options getOptions() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.getOptions()
        : this.options;
  }

  /**
   * @return The value of the {@code optionsDirect} attribute
   */
  @Override
  public @Nullable Options optionsDirect() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.optionsDirect()
        : this.optionsDirect;
  }

  /**
   * @return The value of the {@code optionsBuilder} attribute
   */
  @Override
  public @Nullable Supplier<Options> optionsBuilder() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.optionsBuilder()
        : this.optionsBuilder;
  }

  /**
   * @return The value of the {@code parser} attribute
   */
  @Override
  public AbstractOwlModuleParser.ParseFunction<CommandLine, InputReader> parser() {
    return parser;
  }

  /**
   * @return The value of the {@code key} attribute
   */
  @Override
  public String getKey() {
    return key;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractOwlModuleParser.AbstractReaderParser#getDescription() description} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for description
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableReaderParser withDescription(String value) {
    if (this.description.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "description");
    return new ImmutableReaderParser(newValue, this.optionsDirect, this.optionsBuilder, this.parser, this.key);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractOwlModuleParser.AbstractReaderParser#optionsDirect() optionsDirect} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for optionsDirect (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableReaderParser withOptionsDirect(@Nullable Options value) {
    if (this.optionsDirect == value) return this;
    return new ImmutableReaderParser(this.description, value, this.optionsBuilder, this.parser, this.key);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractOwlModuleParser.AbstractReaderParser#optionsBuilder() optionsBuilder} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for optionsBuilder (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableReaderParser withOptionsBuilder(@Nullable Supplier<Options> value) {
    if (this.optionsBuilder == value) return this;
    return new ImmutableReaderParser(this.description, this.optionsDirect, value, this.parser, this.key);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractOwlModuleParser.AbstractReaderParser#parser() parser} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for parser
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableReaderParser withParser(AbstractOwlModuleParser.ParseFunction<CommandLine, InputReader> value) {
    if (this.parser == value) return this;
    AbstractOwlModuleParser.ParseFunction<CommandLine, InputReader> newValue = Objects.requireNonNull(value, "parser");
    return new ImmutableReaderParser(this.description, this.optionsDirect, this.optionsBuilder, newValue, this.key);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractOwlModuleParser.AbstractReaderParser#getKey() key} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for key
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableReaderParser withKey(String value) {
    if (this.key.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "key");
    return new ImmutableReaderParser(this.description, this.optionsDirect, this.optionsBuilder, this.parser, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableReaderParser} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableReaderParser
        && equalTo((ImmutableReaderParser) another);
  }

  private boolean equalTo(ImmutableReaderParser another) {
    return description.equals(another.description)
        && options.equals(another.options)
        && Objects.equals(optionsDirect, another.optionsDirect)
        && Objects.equals(optionsBuilder, another.optionsBuilder)
        && parser.equals(another.parser)
        && key.equals(another.key);
  }

  /**
   * Computes a hash code from attributes: {@code description}, {@code options}, {@code optionsDirect}, {@code optionsBuilder}, {@code parser}, {@code key}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + description.hashCode();
    h += (h << 5) + options.hashCode();
    h += (h << 5) + Objects.hashCode(optionsDirect);
    h += (h << 5) + Objects.hashCode(optionsBuilder);
    h += (h << 5) + parser.hashCode();
    h += (h << 5) + key.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ReaderParser} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ReaderParser")
        .omitNullValues()
        .add("description", description)
        .add("options", options)
        .add("optionsDirect", optionsDirect)
        .add("optionsBuilder", optionsBuilder)
        .add("parser", parser)
        .add("key", key)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link AbstractOwlModuleParser.AbstractReaderParser} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ReaderParser instance
   */
  static ImmutableReaderParser copyOf(AbstractOwlModuleParser.AbstractReaderParser instance) {
    if (instance instanceof ImmutableReaderParser) {
      return (ImmutableReaderParser) instance;
    }
    return ImmutableReaderParser.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableReaderParser ImmutableReaderParser}.
   * @return A new ImmutableReaderParser builder
   */
  public static ImmutableReaderParser.Builder builder() {
    return new ImmutableReaderParser.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableReaderParser ImmutableReaderParser}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_PARSER = 0x1L;
    private static final long INIT_BIT_KEY = 0x2L;
    private static final long OPT_BIT_OPTIONS_DIRECT = 0x1L;
    private static final long OPT_BIT_OPTIONS_BUILDER = 0x2L;
    private long initBits = 0x3L;
    private long optBits;

    private @Nullable String description;
    private @Nullable Options optionsDirect;
    private @Nullable Supplier<Options> optionsBuilder;
    private @Nullable AbstractOwlModuleParser.ParseFunction<CommandLine, InputReader> parser;
    private @Nullable String key;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ImmutableReaderParser} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ImmutableReaderParser instance) {
      return from((AbstractOwlModuleParser.AbstractReaderParser) instance);
    }

    /**
     * Copy abstract value type {@code AbstractReaderParser} instance into builder.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    final Builder from(AbstractOwlModuleParser.AbstractReaderParser instance) {
      Objects.requireNonNull(instance, "instance");
      description(instance.getDescription());
      @Nullable Options optionsDirectValue = instance.optionsDirect();
      if (optionsDirectValue != null) {
        optionsDirect(optionsDirectValue);
      }
      @Nullable Supplier<Options> optionsBuilderValue = instance.optionsBuilder();
      if (optionsBuilderValue != null) {
        optionsBuilder(optionsBuilderValue);
      }
      parser(instance.parser());
      key(instance.getKey());
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractOwlModuleParser.AbstractReaderParser#getDescription() description} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link AbstractOwlModuleParser.AbstractReaderParser#getDescription() description}.</em>
     * @param description The value for description 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder description(String description) {
      this.description = Objects.requireNonNull(description, "description");
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractOwlModuleParser.AbstractReaderParser#optionsDirect() optionsDirect} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link AbstractOwlModuleParser.AbstractReaderParser#optionsDirect() optionsDirect}.</em>
     * @param optionsDirect The value for optionsDirect (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder optionsDirect(@Nullable Options optionsDirect) {
      this.optionsDirect = optionsDirect;
      optBits |= OPT_BIT_OPTIONS_DIRECT;
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractOwlModuleParser.AbstractReaderParser#optionsBuilder() optionsBuilder} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link AbstractOwlModuleParser.AbstractReaderParser#optionsBuilder() optionsBuilder}.</em>
     * @param optionsBuilder The value for optionsBuilder (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder optionsBuilder(@Nullable Supplier<Options> optionsBuilder) {
      this.optionsBuilder = optionsBuilder;
      optBits |= OPT_BIT_OPTIONS_BUILDER;
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractOwlModuleParser.AbstractReaderParser#parser() parser} attribute.
     * @param parser The value for parser 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder parser(AbstractOwlModuleParser.ParseFunction<CommandLine, InputReader> parser) {
      this.parser = Objects.requireNonNull(parser, "parser");
      initBits &= ~INIT_BIT_PARSER;
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractOwlModuleParser.AbstractReaderParser#getKey() key} attribute.
     * @param key The value for key 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder key(String key) {
      this.key = Objects.requireNonNull(key, "key");
      initBits &= ~INIT_BIT_KEY;
      return this;
    }

    /**
     * Builds a new {@link ImmutableReaderParser ImmutableReaderParser}.
     * @return An immutable instance of ReaderParser
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableReaderParser build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableReaderParser(this);
    }

    private boolean optionsDirectIsSet() {
      return (optBits & OPT_BIT_OPTIONS_DIRECT) != 0;
    }

    private boolean optionsBuilderIsSet() {
      return (optBits & OPT_BIT_OPTIONS_BUILDER) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_PARSER) != 0) attributes.add("parser");
      if ((initBits & INIT_BIT_KEY) != 0) attributes.add("key");
      return "Cannot build ReaderParser, some of required attributes are not set " + attributes;
    }
  }
}
