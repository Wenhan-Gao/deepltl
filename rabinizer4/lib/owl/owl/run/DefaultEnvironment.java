package owl.run;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import owl.factories.FactorySupplier;

/**
 * Immutable implementation of {@link AbstractDefaultEnvironment}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code DefaultEnvironment.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code DefaultEnvironment.of()}.
 */
@SuppressWarnings({"all"})
@SuppressFBWarnings
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AbstractDefaultEnvironment"})
@Immutable
@CheckReturnValue
public final class DefaultEnvironment extends AbstractDefaultEnvironment {
  private final boolean annotations;
  private final FactorySupplier factorySupplier;
  private final boolean lenient;
  private final boolean metaInformation;
  private final boolean parallel;

  private DefaultEnvironment(boolean annotations, boolean metaInformation, boolean parallel) {
    this.annotations = annotations;
    this.metaInformation = metaInformation;
    this.parallel = parallel;
    this.factorySupplier = initShim.factorySupplier();
    this.lenient = initShim.lenient();
    this.initShim = null;
  }

  private DefaultEnvironment(DefaultEnvironment.Builder builder) {
    this.annotations = builder.annotations;
    this.metaInformation = builder.metaInformation;
    this.parallel = builder.parallel;
    if (builder.lenientIsSet()) {
      initShim.lenient(builder.lenient);
    }
    this.lenient = initShim.lenient();
    this.factorySupplier = initShim.factorySupplier();
    this.initShim = null;
  }

  private DefaultEnvironment(boolean annotations, boolean lenient, boolean metaInformation, boolean parallel) {
    this.annotations = annotations;
    this.lenient = lenient;
    this.metaInformation = metaInformation;
    this.parallel = parallel;
    initShim.lenient(this.lenient);
    this.factorySupplier = initShim.factorySupplier();
    this.initShim = null;
  }

  private static final int STAGE_INITIALIZING = -1;
  private static final int STAGE_UNINITIALIZED = 0;
  private static final int STAGE_INITIALIZED = 1;
  private transient volatile InitShim initShim = new InitShim();

  private final class InitShim {
    private FactorySupplier factorySupplier;
    private int factorySupplierBuildStage;

    FactorySupplier factorySupplier() {
      if (factorySupplierBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (factorySupplierBuildStage == STAGE_UNINITIALIZED) {
        factorySupplierBuildStage = STAGE_INITIALIZING;
        this.factorySupplier = Objects.requireNonNull(DefaultEnvironment.super.factorySupplier(), "factorySupplier");
        factorySupplierBuildStage = STAGE_INITIALIZED;
      }
      return this.factorySupplier;
    }
    private boolean lenient;
    private int lenientBuildStage;

    boolean lenient() {
      if (lenientBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (lenientBuildStage == STAGE_UNINITIALIZED) {
        lenientBuildStage = STAGE_INITIALIZING;
        this.lenient = DefaultEnvironment.super.lenient();
        lenientBuildStage = STAGE_INITIALIZED;
      }
      return this.lenient;
    }

    void lenient(boolean lenient) {
      this.lenient = lenient;
      lenientBuildStage = STAGE_INITIALIZED;
    }

    private String formatInitCycleMessage() {
      ArrayList<String> attributes = Lists.newArrayList();
      if (factorySupplierBuildStage == STAGE_INITIALIZING) attributes.add("factorySupplier");
      if (lenientBuildStage == STAGE_INITIALIZING) attributes.add("lenient");
      return "Cannot build DefaultEnvironment, attribute initializers form cycle" + attributes;
    }
  }

  /**
   * @return The value of the {@code annotations} attribute
   */
  @Override
  public boolean annotations() {
    return annotations;
  }

  /**
   * @return The computed-at-construction value of the {@code factorySupplier} attribute
   */
  @Override
  public FactorySupplier factorySupplier() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.factorySupplier()
        : this.factorySupplier;
  }

  /**
   * @return The value of the {@code lenient} attribute
   */
  @Override
  public boolean lenient() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.lenient()
        : this.lenient;
  }

  /**
   * @return The value of the {@code metaInformation} attribute
   */
  @Override
  public boolean metaInformation() {
    return metaInformation;
  }

  /**
   * @return The value of the {@code parallel} attribute
   */
  @Override
  public boolean parallel() {
    return parallel;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractDefaultEnvironment#annotations() annotations} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for annotations
   * @return A modified copy of the {@code this} object
   */
  public final DefaultEnvironment withAnnotations(boolean value) {
    if (this.annotations == value) return this;
    return new DefaultEnvironment(value, this.lenient, this.metaInformation, this.parallel);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractDefaultEnvironment#lenient() lenient} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for lenient
   * @return A modified copy of the {@code this} object
   */
  public final DefaultEnvironment withLenient(boolean value) {
    if (this.lenient == value) return this;
    return new DefaultEnvironment(this.annotations, value, this.metaInformation, this.parallel);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractDefaultEnvironment#metaInformation() metaInformation} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for metaInformation
   * @return A modified copy of the {@code this} object
   */
  public final DefaultEnvironment withMetaInformation(boolean value) {
    if (this.metaInformation == value) return this;
    return new DefaultEnvironment(this.annotations, this.lenient, value, this.parallel);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractDefaultEnvironment#parallel() parallel} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for parallel
   * @return A modified copy of the {@code this} object
   */
  public final DefaultEnvironment withParallel(boolean value) {
    if (this.parallel == value) return this;
    return new DefaultEnvironment(this.annotations, this.lenient, this.metaInformation, value);
  }

  /**
   * This instance is equal to all instances of {@code DefaultEnvironment} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof DefaultEnvironment
        && equalTo((DefaultEnvironment) another);
  }

  private boolean equalTo(DefaultEnvironment another) {
    return annotations == another.annotations
        && factorySupplier.equals(another.factorySupplier)
        && lenient == another.lenient
        && metaInformation == another.metaInformation
        && parallel == another.parallel;
  }

  /**
   * Computes a hash code from attributes: {@code annotations}, {@code factorySupplier}, {@code lenient}, {@code metaInformation}, {@code parallel}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Booleans.hashCode(annotations);
    h += (h << 5) + factorySupplier.hashCode();
    h += (h << 5) + Booleans.hashCode(lenient);
    h += (h << 5) + Booleans.hashCode(metaInformation);
    h += (h << 5) + Booleans.hashCode(parallel);
    return h;
  }

  /**
   * Prints the immutable value {@code DefaultEnvironment} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("DefaultEnvironment")
        .omitNullValues()
        .add("annotations", annotations)
        .add("factorySupplier", factorySupplier)
        .add("lenient", lenient)
        .add("metaInformation", metaInformation)
        .add("parallel", parallel)
        .toString();
  }

  /**
   * Construct a new immutable {@code DefaultEnvironment} instance.
   * @param annotations The value for the {@code annotations} attribute
   * @param metaInformation The value for the {@code metaInformation} attribute
   * @param parallel The value for the {@code parallel} attribute
   * @return An immutable DefaultEnvironment instance
   */
  public static DefaultEnvironment of(boolean annotations, boolean metaInformation, boolean parallel) {
    return new DefaultEnvironment(annotations, metaInformation, parallel);
  }

  /**
   * Creates an immutable copy of a {@link AbstractDefaultEnvironment} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable DefaultEnvironment instance
   */
  static DefaultEnvironment copyOf(AbstractDefaultEnvironment instance) {
    if (instance instanceof DefaultEnvironment) {
      return (DefaultEnvironment) instance;
    }
    return DefaultEnvironment.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link DefaultEnvironment DefaultEnvironment}.
   * @return A new DefaultEnvironment builder
   */
  public static DefaultEnvironment.Builder builder() {
    return new DefaultEnvironment.Builder();
  }

  /**
   * Builds instances of type {@link DefaultEnvironment DefaultEnvironment}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ANNOTATIONS = 0x1L;
    private static final long INIT_BIT_META_INFORMATION = 0x2L;
    private static final long INIT_BIT_PARALLEL = 0x4L;
    private static final long OPT_BIT_LENIENT = 0x1L;
    private long initBits = 0x7L;
    private long optBits;

    private boolean annotations;
    private boolean lenient;
    private boolean metaInformation;
    private boolean parallel;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code owl.run.Environment} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Environment instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code DefaultEnvironment} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(DefaultEnvironment instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Copy abstract value type {@code AbstractDefaultEnvironment} instance into builder.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    final Builder from(AbstractDefaultEnvironment instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      long bits = 0;
      if (object instanceof Environment) {
        Environment instance = (Environment) object;
        if ((bits & 0x2L) == 0) {
          annotations(instance.annotations());
          bits |= 0x2L;
        }
        if ((bits & 0x4L) == 0) {
          metaInformation(instance.metaInformation());
          bits |= 0x4L;
        }
        if ((bits & 0x1L) == 0) {
          parallel(instance.parallel());
          bits |= 0x1L;
        }
        if ((bits & 0x8L) == 0) {
          lenient(instance.lenient());
          bits |= 0x8L;
        }
      }
      if (object instanceof AbstractDefaultEnvironment) {
        AbstractDefaultEnvironment instance = (AbstractDefaultEnvironment) object;
        if ((bits & 0x2L) == 0) {
          annotations(instance.annotations());
          bits |= 0x2L;
        }
        if ((bits & 0x4L) == 0) {
          metaInformation(instance.metaInformation());
          bits |= 0x4L;
        }
        if ((bits & 0x1L) == 0) {
          parallel(instance.parallel());
          bits |= 0x1L;
        }
        if ((bits & 0x8L) == 0) {
          lenient(instance.lenient());
          bits |= 0x8L;
        }
      }
    }

    /**
     * Initializes the value for the {@link AbstractDefaultEnvironment#annotations() annotations} attribute.
     * @param annotations The value for annotations 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder annotations(boolean annotations) {
      this.annotations = annotations;
      initBits &= ~INIT_BIT_ANNOTATIONS;
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractDefaultEnvironment#lenient() lenient} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link AbstractDefaultEnvironment#lenient() lenient}.</em>
     * @param lenient The value for lenient 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder lenient(boolean lenient) {
      this.lenient = lenient;
      optBits |= OPT_BIT_LENIENT;
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractDefaultEnvironment#metaInformation() metaInformation} attribute.
     * @param metaInformation The value for metaInformation 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder metaInformation(boolean metaInformation) {
      this.metaInformation = metaInformation;
      initBits &= ~INIT_BIT_META_INFORMATION;
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractDefaultEnvironment#parallel() parallel} attribute.
     * @param parallel The value for parallel 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder parallel(boolean parallel) {
      this.parallel = parallel;
      initBits &= ~INIT_BIT_PARALLEL;
      return this;
    }

    /**
     * Builds a new {@link DefaultEnvironment DefaultEnvironment}.
     * @return An immutable instance of DefaultEnvironment
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public DefaultEnvironment build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new DefaultEnvironment(this);
    }

    private boolean lenientIsSet() {
      return (optBits & OPT_BIT_LENIENT) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_ANNOTATIONS) != 0) attributes.add("annotations");
      if ((initBits & INIT_BIT_META_INFORMATION) != 0) attributes.add("metaInformation");
      if ((initBits & INIT_BIT_PARALLEL) != 0) attributes.add("parallel");
      return "Cannot build DefaultEnvironment, some of required attributes are not set " + attributes;
    }
  }
}
