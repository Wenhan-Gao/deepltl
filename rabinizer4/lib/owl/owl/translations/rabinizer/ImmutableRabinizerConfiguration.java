package owl.translations.rabinizer;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link RabinizerConfiguration}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableRabinizerConfiguration.builder()}.
 */
@SuppressWarnings({"all"})
@SuppressFBWarnings
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "RabinizerConfiguration"})
@Immutable
@CheckReturnValue
public final class ImmutableRabinizerConfiguration extends RabinizerConfiguration {
  private final boolean completeAutomaton;
  private final boolean computeAcceptance;
  private final boolean eager;
  private final boolean supportBasedRelevantFormulaAnalysis;
  private final boolean suspendableFormulaDetection;
  private final boolean removeFormulaRepresentative;

  private ImmutableRabinizerConfiguration(ImmutableRabinizerConfiguration.Builder builder) {
    if (builder.completeAutomatonIsSet()) {
      initShim.completeAutomaton(builder.completeAutomaton);
    }
    if (builder.computeAcceptanceIsSet()) {
      initShim.computeAcceptance(builder.computeAcceptance);
    }
    if (builder.eagerIsSet()) {
      initShim.eager(builder.eager);
    }
    if (builder.supportBasedRelevantFormulaAnalysisIsSet()) {
      initShim.supportBasedRelevantFormulaAnalysis(builder.supportBasedRelevantFormulaAnalysis);
    }
    if (builder.suspendableFormulaDetectionIsSet()) {
      initShim.suspendableFormulaDetection(builder.suspendableFormulaDetection);
    }
    if (builder.removeFormulaRepresentativeIsSet()) {
      initShim.removeFormulaRepresentative(builder.removeFormulaRepresentative);
    }
    this.completeAutomaton = initShim.completeAutomaton();
    this.computeAcceptance = initShim.computeAcceptance();
    this.eager = initShim.eager();
    this.supportBasedRelevantFormulaAnalysis = initShim.supportBasedRelevantFormulaAnalysis();
    this.suspendableFormulaDetection = initShim.suspendableFormulaDetection();
    this.removeFormulaRepresentative = initShim.removeFormulaRepresentative();
    this.initShim = null;
  }

  private ImmutableRabinizerConfiguration(
      boolean completeAutomaton,
      boolean computeAcceptance,
      boolean eager,
      boolean supportBasedRelevantFormulaAnalysis,
      boolean suspendableFormulaDetection,
      boolean removeFormulaRepresentative) {
    this.completeAutomaton = completeAutomaton;
    this.computeAcceptance = computeAcceptance;
    this.eager = eager;
    this.supportBasedRelevantFormulaAnalysis = supportBasedRelevantFormulaAnalysis;
    this.suspendableFormulaDetection = suspendableFormulaDetection;
    this.removeFormulaRepresentative = removeFormulaRepresentative;
    this.initShim = null;
  }

  private static final int STAGE_INITIALIZING = -1;
  private static final int STAGE_UNINITIALIZED = 0;
  private static final int STAGE_INITIALIZED = 1;
  private transient volatile InitShim initShim = new InitShim();

  private final class InitShim {
    private boolean completeAutomaton;
    private int completeAutomatonBuildStage;

    boolean completeAutomaton() {
      if (completeAutomatonBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (completeAutomatonBuildStage == STAGE_UNINITIALIZED) {
        completeAutomatonBuildStage = STAGE_INITIALIZING;
        this.completeAutomaton = ImmutableRabinizerConfiguration.super.completeAutomaton();
        completeAutomatonBuildStage = STAGE_INITIALIZED;
      }
      return this.completeAutomaton;
    }

    void completeAutomaton(boolean completeAutomaton) {
      this.completeAutomaton = completeAutomaton;
      completeAutomatonBuildStage = STAGE_INITIALIZED;
    }
    private boolean computeAcceptance;
    private int computeAcceptanceBuildStage;

    boolean computeAcceptance() {
      if (computeAcceptanceBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (computeAcceptanceBuildStage == STAGE_UNINITIALIZED) {
        computeAcceptanceBuildStage = STAGE_INITIALIZING;
        this.computeAcceptance = ImmutableRabinizerConfiguration.super.computeAcceptance();
        computeAcceptanceBuildStage = STAGE_INITIALIZED;
      }
      return this.computeAcceptance;
    }

    void computeAcceptance(boolean computeAcceptance) {
      this.computeAcceptance = computeAcceptance;
      computeAcceptanceBuildStage = STAGE_INITIALIZED;
    }
    private boolean eager;
    private int eagerBuildStage;

    boolean eager() {
      if (eagerBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (eagerBuildStage == STAGE_UNINITIALIZED) {
        eagerBuildStage = STAGE_INITIALIZING;
        this.eager = ImmutableRabinizerConfiguration.super.eager();
        eagerBuildStage = STAGE_INITIALIZED;
      }
      return this.eager;
    }

    void eager(boolean eager) {
      this.eager = eager;
      eagerBuildStage = STAGE_INITIALIZED;
    }
    private boolean supportBasedRelevantFormulaAnalysis;
    private int supportBasedRelevantFormulaAnalysisBuildStage;

    boolean supportBasedRelevantFormulaAnalysis() {
      if (supportBasedRelevantFormulaAnalysisBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (supportBasedRelevantFormulaAnalysisBuildStage == STAGE_UNINITIALIZED) {
        supportBasedRelevantFormulaAnalysisBuildStage = STAGE_INITIALIZING;
        this.supportBasedRelevantFormulaAnalysis = ImmutableRabinizerConfiguration.super.supportBasedRelevantFormulaAnalysis();
        supportBasedRelevantFormulaAnalysisBuildStage = STAGE_INITIALIZED;
      }
      return this.supportBasedRelevantFormulaAnalysis;
    }

    void supportBasedRelevantFormulaAnalysis(boolean supportBasedRelevantFormulaAnalysis) {
      this.supportBasedRelevantFormulaAnalysis = supportBasedRelevantFormulaAnalysis;
      supportBasedRelevantFormulaAnalysisBuildStage = STAGE_INITIALIZED;
    }
    private boolean suspendableFormulaDetection;
    private int suspendableFormulaDetectionBuildStage;

    boolean suspendableFormulaDetection() {
      if (suspendableFormulaDetectionBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (suspendableFormulaDetectionBuildStage == STAGE_UNINITIALIZED) {
        suspendableFormulaDetectionBuildStage = STAGE_INITIALIZING;
        this.suspendableFormulaDetection = ImmutableRabinizerConfiguration.super.suspendableFormulaDetection();
        suspendableFormulaDetectionBuildStage = STAGE_INITIALIZED;
      }
      return this.suspendableFormulaDetection;
    }

    void suspendableFormulaDetection(boolean suspendableFormulaDetection) {
      this.suspendableFormulaDetection = suspendableFormulaDetection;
      suspendableFormulaDetectionBuildStage = STAGE_INITIALIZED;
    }
    private boolean removeFormulaRepresentative;
    private int removeFormulaRepresentativeBuildStage;

    boolean removeFormulaRepresentative() {
      if (removeFormulaRepresentativeBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (removeFormulaRepresentativeBuildStage == STAGE_UNINITIALIZED) {
        removeFormulaRepresentativeBuildStage = STAGE_INITIALIZING;
        this.removeFormulaRepresentative = ImmutableRabinizerConfiguration.super.removeFormulaRepresentative();
        removeFormulaRepresentativeBuildStage = STAGE_INITIALIZED;
      }
      return this.removeFormulaRepresentative;
    }

    void removeFormulaRepresentative(boolean removeFormulaRepresentative) {
      this.removeFormulaRepresentative = removeFormulaRepresentative;
      removeFormulaRepresentativeBuildStage = STAGE_INITIALIZED;
    }

    private String formatInitCycleMessage() {
      ArrayList<String> attributes = Lists.newArrayList();
      if (completeAutomatonBuildStage == STAGE_INITIALIZING) attributes.add("completeAutomaton");
      if (computeAcceptanceBuildStage == STAGE_INITIALIZING) attributes.add("computeAcceptance");
      if (eagerBuildStage == STAGE_INITIALIZING) attributes.add("eager");
      if (supportBasedRelevantFormulaAnalysisBuildStage == STAGE_INITIALIZING) attributes.add("supportBasedRelevantFormulaAnalysis");
      if (suspendableFormulaDetectionBuildStage == STAGE_INITIALIZING) attributes.add("suspendableFormulaDetection");
      if (removeFormulaRepresentativeBuildStage == STAGE_INITIALIZING) attributes.add("removeFormulaRepresentative");
      return "Cannot build RabinizerConfiguration, attribute initializers form cycle" + attributes;
    }
  }

  /**
   * @return The value of the {@code completeAutomaton} attribute
   */
  @Override
  public boolean completeAutomaton() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.completeAutomaton()
        : this.completeAutomaton;
  }

  /**
   * @return The value of the {@code computeAcceptance} attribute
   */
  @Override
  public boolean computeAcceptance() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.computeAcceptance()
        : this.computeAcceptance;
  }

  /**
   * @return The value of the {@code eager} attribute
   */
  @Override
  public boolean eager() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.eager()
        : this.eager;
  }

  /**
   * @return The value of the {@code supportBasedRelevantFormulaAnalysis} attribute
   */
  @Override
  public boolean supportBasedRelevantFormulaAnalysis() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.supportBasedRelevantFormulaAnalysis()
        : this.supportBasedRelevantFormulaAnalysis;
  }

  /**
   * @return The value of the {@code suspendableFormulaDetection} attribute
   */
  @Override
  public boolean suspendableFormulaDetection() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.suspendableFormulaDetection()
        : this.suspendableFormulaDetection;
  }

  /**
   * @return The value of the {@code removeFormulaRepresentative} attribute
   */
  @Override
  public boolean removeFormulaRepresentative() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.removeFormulaRepresentative()
        : this.removeFormulaRepresentative;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RabinizerConfiguration#completeAutomaton() completeAutomaton} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for completeAutomaton
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRabinizerConfiguration withCompleteAutomaton(boolean value) {
    if (this.completeAutomaton == value) return this;
    return new ImmutableRabinizerConfiguration(
        value,
        this.computeAcceptance,
        this.eager,
        this.supportBasedRelevantFormulaAnalysis,
        this.suspendableFormulaDetection,
        this.removeFormulaRepresentative);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RabinizerConfiguration#computeAcceptance() computeAcceptance} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for computeAcceptance
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRabinizerConfiguration withComputeAcceptance(boolean value) {
    if (this.computeAcceptance == value) return this;
    return new ImmutableRabinizerConfiguration(
        this.completeAutomaton,
        value,
        this.eager,
        this.supportBasedRelevantFormulaAnalysis,
        this.suspendableFormulaDetection,
        this.removeFormulaRepresentative);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RabinizerConfiguration#eager() eager} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eager
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRabinizerConfiguration withEager(boolean value) {
    if (this.eager == value) return this;
    return new ImmutableRabinizerConfiguration(
        this.completeAutomaton,
        this.computeAcceptance,
        value,
        this.supportBasedRelevantFormulaAnalysis,
        this.suspendableFormulaDetection,
        this.removeFormulaRepresentative);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RabinizerConfiguration#supportBasedRelevantFormulaAnalysis() supportBasedRelevantFormulaAnalysis} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for supportBasedRelevantFormulaAnalysis
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRabinizerConfiguration withSupportBasedRelevantFormulaAnalysis(boolean value) {
    if (this.supportBasedRelevantFormulaAnalysis == value) return this;
    return new ImmutableRabinizerConfiguration(
        this.completeAutomaton,
        this.computeAcceptance,
        this.eager,
        value,
        this.suspendableFormulaDetection,
        this.removeFormulaRepresentative);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RabinizerConfiguration#suspendableFormulaDetection() suspendableFormulaDetection} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for suspendableFormulaDetection
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRabinizerConfiguration withSuspendableFormulaDetection(boolean value) {
    if (this.suspendableFormulaDetection == value) return this;
    return new ImmutableRabinizerConfiguration(
        this.completeAutomaton,
        this.computeAcceptance,
        this.eager,
        this.supportBasedRelevantFormulaAnalysis,
        value,
        this.removeFormulaRepresentative);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RabinizerConfiguration#removeFormulaRepresentative() removeFormulaRepresentative} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for removeFormulaRepresentative
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRabinizerConfiguration withRemoveFormulaRepresentative(boolean value) {
    if (this.removeFormulaRepresentative == value) return this;
    return new ImmutableRabinizerConfiguration(
        this.completeAutomaton,
        this.computeAcceptance,
        this.eager,
        this.supportBasedRelevantFormulaAnalysis,
        this.suspendableFormulaDetection,
        value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableRabinizerConfiguration} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableRabinizerConfiguration
        && equalTo((ImmutableRabinizerConfiguration) another);
  }

  private boolean equalTo(ImmutableRabinizerConfiguration another) {
    return completeAutomaton == another.completeAutomaton
        && computeAcceptance == another.computeAcceptance
        && eager == another.eager
        && supportBasedRelevantFormulaAnalysis == another.supportBasedRelevantFormulaAnalysis
        && suspendableFormulaDetection == another.suspendableFormulaDetection
        && removeFormulaRepresentative == another.removeFormulaRepresentative;
  }

  /**
   * Computes a hash code from attributes: {@code completeAutomaton}, {@code computeAcceptance}, {@code eager}, {@code supportBasedRelevantFormulaAnalysis}, {@code suspendableFormulaDetection}, {@code removeFormulaRepresentative}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Booleans.hashCode(completeAutomaton);
    h += (h << 5) + Booleans.hashCode(computeAcceptance);
    h += (h << 5) + Booleans.hashCode(eager);
    h += (h << 5) + Booleans.hashCode(supportBasedRelevantFormulaAnalysis);
    h += (h << 5) + Booleans.hashCode(suspendableFormulaDetection);
    h += (h << 5) + Booleans.hashCode(removeFormulaRepresentative);
    return h;
  }

  /**
   * Prints the immutable value {@code RabinizerConfiguration} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("RabinizerConfiguration")
        .omitNullValues()
        .add("completeAutomaton", completeAutomaton)
        .add("computeAcceptance", computeAcceptance)
        .add("eager", eager)
        .add("supportBasedRelevantFormulaAnalysis", supportBasedRelevantFormulaAnalysis)
        .add("suspendableFormulaDetection", suspendableFormulaDetection)
        .add("removeFormulaRepresentative", removeFormulaRepresentative)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link RabinizerConfiguration} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable RabinizerConfiguration instance
   */
  public static ImmutableRabinizerConfiguration copyOf(RabinizerConfiguration instance) {
    if (instance instanceof ImmutableRabinizerConfiguration) {
      return (ImmutableRabinizerConfiguration) instance;
    }
    return ImmutableRabinizerConfiguration.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableRabinizerConfiguration ImmutableRabinizerConfiguration}.
   * @return A new ImmutableRabinizerConfiguration builder
   */
  public static ImmutableRabinizerConfiguration.Builder builder() {
    return new ImmutableRabinizerConfiguration.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableRabinizerConfiguration ImmutableRabinizerConfiguration}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long OPT_BIT_COMPLETE_AUTOMATON = 0x1L;
    private static final long OPT_BIT_COMPUTE_ACCEPTANCE = 0x2L;
    private static final long OPT_BIT_EAGER = 0x4L;
    private static final long OPT_BIT_SUPPORT_BASED_RELEVANT_FORMULA_ANALYSIS = 0x8L;
    private static final long OPT_BIT_SUSPENDABLE_FORMULA_DETECTION = 0x10L;
    private static final long OPT_BIT_REMOVE_FORMULA_REPRESENTATIVE = 0x20L;
    private long optBits;

    private boolean completeAutomaton;
    private boolean computeAcceptance;
    private boolean eager;
    private boolean supportBasedRelevantFormulaAnalysis;
    private boolean suspendableFormulaDetection;
    private boolean removeFormulaRepresentative;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code RabinizerConfiguration} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(RabinizerConfiguration instance) {
      Objects.requireNonNull(instance, "instance");
      completeAutomaton(instance.completeAutomaton());
      computeAcceptance(instance.computeAcceptance());
      eager(instance.eager());
      supportBasedRelevantFormulaAnalysis(instance.supportBasedRelevantFormulaAnalysis());
      suspendableFormulaDetection(instance.suspendableFormulaDetection());
      removeFormulaRepresentative(instance.removeFormulaRepresentative());
      return this;
    }

    /**
     * Initializes the value for the {@link RabinizerConfiguration#completeAutomaton() completeAutomaton} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link RabinizerConfiguration#completeAutomaton() completeAutomaton}.</em>
     * @param completeAutomaton The value for completeAutomaton 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder completeAutomaton(boolean completeAutomaton) {
      this.completeAutomaton = completeAutomaton;
      optBits |= OPT_BIT_COMPLETE_AUTOMATON;
      return this;
    }

    /**
     * Initializes the value for the {@link RabinizerConfiguration#computeAcceptance() computeAcceptance} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link RabinizerConfiguration#computeAcceptance() computeAcceptance}.</em>
     * @param computeAcceptance The value for computeAcceptance 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder computeAcceptance(boolean computeAcceptance) {
      this.computeAcceptance = computeAcceptance;
      optBits |= OPT_BIT_COMPUTE_ACCEPTANCE;
      return this;
    }

    /**
     * Initializes the value for the {@link RabinizerConfiguration#eager() eager} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link RabinizerConfiguration#eager() eager}.</em>
     * @param eager The value for eager 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder eager(boolean eager) {
      this.eager = eager;
      optBits |= OPT_BIT_EAGER;
      return this;
    }

    /**
     * Initializes the value for the {@link RabinizerConfiguration#supportBasedRelevantFormulaAnalysis() supportBasedRelevantFormulaAnalysis} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link RabinizerConfiguration#supportBasedRelevantFormulaAnalysis() supportBasedRelevantFormulaAnalysis}.</em>
     * @param supportBasedRelevantFormulaAnalysis The value for supportBasedRelevantFormulaAnalysis 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder supportBasedRelevantFormulaAnalysis(boolean supportBasedRelevantFormulaAnalysis) {
      this.supportBasedRelevantFormulaAnalysis = supportBasedRelevantFormulaAnalysis;
      optBits |= OPT_BIT_SUPPORT_BASED_RELEVANT_FORMULA_ANALYSIS;
      return this;
    }

    /**
     * Initializes the value for the {@link RabinizerConfiguration#suspendableFormulaDetection() suspendableFormulaDetection} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link RabinizerConfiguration#suspendableFormulaDetection() suspendableFormulaDetection}.</em>
     * @param suspendableFormulaDetection The value for suspendableFormulaDetection 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder suspendableFormulaDetection(boolean suspendableFormulaDetection) {
      this.suspendableFormulaDetection = suspendableFormulaDetection;
      optBits |= OPT_BIT_SUSPENDABLE_FORMULA_DETECTION;
      return this;
    }

    /**
     * Initializes the value for the {@link RabinizerConfiguration#removeFormulaRepresentative() removeFormulaRepresentative} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link RabinizerConfiguration#removeFormulaRepresentative() removeFormulaRepresentative}.</em>
     * @param removeFormulaRepresentative The value for removeFormulaRepresentative 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder removeFormulaRepresentative(boolean removeFormulaRepresentative) {
      this.removeFormulaRepresentative = removeFormulaRepresentative;
      optBits |= OPT_BIT_REMOVE_FORMULA_REPRESENTATIVE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableRabinizerConfiguration ImmutableRabinizerConfiguration}.
     * @return An immutable instance of RabinizerConfiguration
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableRabinizerConfiguration build() {
      return new ImmutableRabinizerConfiguration(this);
    }

    private boolean completeAutomatonIsSet() {
      return (optBits & OPT_BIT_COMPLETE_AUTOMATON) != 0;
    }

    private boolean computeAcceptanceIsSet() {
      return (optBits & OPT_BIT_COMPUTE_ACCEPTANCE) != 0;
    }

    private boolean eagerIsSet() {
      return (optBits & OPT_BIT_EAGER) != 0;
    }

    private boolean supportBasedRelevantFormulaAnalysisIsSet() {
      return (optBits & OPT_BIT_SUPPORT_BASED_RELEVANT_FORMULA_ANALYSIS) != 0;
    }

    private boolean suspendableFormulaDetectionIsSet() {
      return (optBits & OPT_BIT_SUSPENDABLE_FORMULA_DETECTION) != 0;
    }

    private boolean removeFormulaRepresentativeIsSet() {
      return (optBits & OPT_BIT_REMOVE_FORMULA_REPRESENTATIVE) != 0;
    }
  }
}
