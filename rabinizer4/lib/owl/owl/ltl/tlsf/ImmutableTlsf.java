package owl.ltl.tlsf;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import owl.ltl.Formula;
import owl.ltl.LabelledFormula;

/**
 * Immutable implementation of {@link Tlsf}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableTlsf.builder()}.
 */
@SuppressWarnings({"ReferenceEquality", "all"})
@SuppressFBWarnings
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Tlsf"})
@Immutable
@CheckReturnValue
public final class ImmutableTlsf extends Tlsf {
  private final ImmutableList<Formula> assert_;
  private final Formula assume;
  private final String description;
  private final ImmutableList<Formula> guarantee;
  private final Formula initially;
  private final BitSet inputs;
  private final BitSet outputs;
  private final ImmutableList<String> variables;
  private final Formula preset;
  private final Formula require;
  private final Tlsf.Semantics semantics;
  private final Tlsf.Semantics target;
  private final String title;
  private final int numberOfInputs;
  private final LabelledFormula toFormula;
  private final List<LabelledFormula> toAssertGuaranteeConjuncts;

  private ImmutableTlsf(ImmutableTlsf.Builder builder) {
    this.description = builder.description;
    this.inputs = builder.inputs;
    this.outputs = builder.outputs;
    this.variables = builder.variables.build();
    this.semantics = builder.semantics;
    this.target = builder.target;
    this.title = builder.title;
    if (builder.assert_IsSet()) {
      initShim.assert_(builder.assert_.build());
    }
    if (builder.assume != null) {
      initShim.assume(builder.assume);
    }
    if (builder.guaranteeIsSet()) {
      initShim.guarantee(builder.guarantee.build());
    }
    if (builder.initially != null) {
      initShim.initially(builder.initially);
    }
    if (builder.preset != null) {
      initShim.preset(builder.preset);
    }
    if (builder.require != null) {
      initShim.require(builder.require);
    }
    this.assert_ = initShim.assert_();
    this.assume = initShim.assume();
    this.guarantee = initShim.guarantee();
    this.initially = initShim.initially();
    this.preset = initShim.preset();
    this.require = initShim.require();
    this.numberOfInputs = initShim.numberOfInputs();
    this.toFormula = initShim.toFormula();
    this.toAssertGuaranteeConjuncts = initShim.toAssertGuaranteeConjuncts();
    this.initShim = null;
  }

  private ImmutableTlsf(
      ImmutableList<Formula> assert_,
      Formula assume,
      String description,
      ImmutableList<Formula> guarantee,
      Formula initially,
      BitSet inputs,
      BitSet outputs,
      ImmutableList<String> variables,
      Formula preset,
      Formula require,
      Tlsf.Semantics semantics,
      Tlsf.Semantics target,
      String title) {
    this.assert_ = assert_;
    this.assume = assume;
    this.description = description;
    this.guarantee = guarantee;
    this.initially = initially;
    this.inputs = inputs;
    this.outputs = outputs;
    this.variables = variables;
    this.preset = preset;
    this.require = require;
    this.semantics = semantics;
    this.target = target;
    this.title = title;
    initShim.assert_(this.assert_);
    initShim.assume(this.assume);
    initShim.guarantee(this.guarantee);
    initShim.initially(this.initially);
    initShim.preset(this.preset);
    initShim.require(this.require);
    this.numberOfInputs = initShim.numberOfInputs();
    this.toFormula = initShim.toFormula();
    this.toAssertGuaranteeConjuncts = initShim.toAssertGuaranteeConjuncts();
    this.initShim = null;
  }

  private static final int STAGE_INITIALIZING = -1;
  private static final int STAGE_UNINITIALIZED = 0;
  private static final int STAGE_INITIALIZED = 1;
  private transient volatile InitShim initShim = new InitShim();

  private final class InitShim {
    private ImmutableList<Formula> assert_;
    private int assert_BuildStage;

    ImmutableList<Formula> assert_() {
      if (assert_BuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (assert_BuildStage == STAGE_UNINITIALIZED) {
        assert_BuildStage = STAGE_INITIALIZING;
        this.assert_ = ImmutableList.copyOf(ImmutableTlsf.super.assert_());
        assert_BuildStage = STAGE_INITIALIZED;
      }
      return this.assert_;
    }

    void assert_(ImmutableList<Formula> assert_) {
      this.assert_ = assert_;
      assert_BuildStage = STAGE_INITIALIZED;
    }
    private Formula assume;
    private int assumeBuildStage;

    Formula assume() {
      if (assumeBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (assumeBuildStage == STAGE_UNINITIALIZED) {
        assumeBuildStage = STAGE_INITIALIZING;
        this.assume = Objects.requireNonNull(ImmutableTlsf.super.assume(), "assume");
        assumeBuildStage = STAGE_INITIALIZED;
      }
      return this.assume;
    }

    void assume(Formula assume) {
      this.assume = assume;
      assumeBuildStage = STAGE_INITIALIZED;
    }
    private ImmutableList<Formula> guarantee;
    private int guaranteeBuildStage;

    ImmutableList<Formula> guarantee() {
      if (guaranteeBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (guaranteeBuildStage == STAGE_UNINITIALIZED) {
        guaranteeBuildStage = STAGE_INITIALIZING;
        this.guarantee = ImmutableList.copyOf(ImmutableTlsf.super.guarantee());
        guaranteeBuildStage = STAGE_INITIALIZED;
      }
      return this.guarantee;
    }

    void guarantee(ImmutableList<Formula> guarantee) {
      this.guarantee = guarantee;
      guaranteeBuildStage = STAGE_INITIALIZED;
    }
    private Formula initially;
    private int initiallyBuildStage;

    Formula initially() {
      if (initiallyBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (initiallyBuildStage == STAGE_UNINITIALIZED) {
        initiallyBuildStage = STAGE_INITIALIZING;
        this.initially = Objects.requireNonNull(ImmutableTlsf.super.initially(), "initially");
        initiallyBuildStage = STAGE_INITIALIZED;
      }
      return this.initially;
    }

    void initially(Formula initially) {
      this.initially = initially;
      initiallyBuildStage = STAGE_INITIALIZED;
    }
    private Formula preset;
    private int presetBuildStage;

    Formula preset() {
      if (presetBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (presetBuildStage == STAGE_UNINITIALIZED) {
        presetBuildStage = STAGE_INITIALIZING;
        this.preset = Objects.requireNonNull(ImmutableTlsf.super.preset(), "preset");
        presetBuildStage = STAGE_INITIALIZED;
      }
      return this.preset;
    }

    void preset(Formula preset) {
      this.preset = preset;
      presetBuildStage = STAGE_INITIALIZED;
    }
    private Formula require;
    private int requireBuildStage;

    Formula require() {
      if (requireBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (requireBuildStage == STAGE_UNINITIALIZED) {
        requireBuildStage = STAGE_INITIALIZING;
        this.require = Objects.requireNonNull(ImmutableTlsf.super.require(), "require");
        requireBuildStage = STAGE_INITIALIZED;
      }
      return this.require;
    }

    void require(Formula require) {
      this.require = require;
      requireBuildStage = STAGE_INITIALIZED;
    }
    private int numberOfInputs;
    private int numberOfInputsBuildStage;

    int numberOfInputs() {
      if (numberOfInputsBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (numberOfInputsBuildStage == STAGE_UNINITIALIZED) {
        numberOfInputsBuildStage = STAGE_INITIALIZING;
        this.numberOfInputs = ImmutableTlsf.super.numberOfInputs();
        numberOfInputsBuildStage = STAGE_INITIALIZED;
      }
      return this.numberOfInputs;
    }
    private LabelledFormula toFormula;
    private int toFormulaBuildStage;

    LabelledFormula toFormula() {
      if (toFormulaBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (toFormulaBuildStage == STAGE_UNINITIALIZED) {
        toFormulaBuildStage = STAGE_INITIALIZING;
        this.toFormula = Objects.requireNonNull(ImmutableTlsf.super.toFormula(), "toFormula");
        toFormulaBuildStage = STAGE_INITIALIZED;
      }
      return this.toFormula;
    }
    private List<LabelledFormula> toAssertGuaranteeConjuncts;
    private int toAssertGuaranteeConjunctsBuildStage;

    List<LabelledFormula> toAssertGuaranteeConjuncts() {
      if (toAssertGuaranteeConjunctsBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (toAssertGuaranteeConjunctsBuildStage == STAGE_UNINITIALIZED) {
        toAssertGuaranteeConjunctsBuildStage = STAGE_INITIALIZING;
        this.toAssertGuaranteeConjuncts = Objects.requireNonNull(ImmutableTlsf.super.toAssertGuaranteeConjuncts(), "toAssertGuaranteeConjuncts");
        toAssertGuaranteeConjunctsBuildStage = STAGE_INITIALIZED;
      }
      return this.toAssertGuaranteeConjuncts;
    }

    private String formatInitCycleMessage() {
      ArrayList<String> attributes = Lists.newArrayList();
      if (assert_BuildStage == STAGE_INITIALIZING) attributes.add("assert_");
      if (assumeBuildStage == STAGE_INITIALIZING) attributes.add("assume");
      if (guaranteeBuildStage == STAGE_INITIALIZING) attributes.add("guarantee");
      if (initiallyBuildStage == STAGE_INITIALIZING) attributes.add("initially");
      if (presetBuildStage == STAGE_INITIALIZING) attributes.add("preset");
      if (requireBuildStage == STAGE_INITIALIZING) attributes.add("require");
      if (numberOfInputsBuildStage == STAGE_INITIALIZING) attributes.add("numberOfInputs");
      if (toFormulaBuildStage == STAGE_INITIALIZING) attributes.add("toFormula");
      if (toAssertGuaranteeConjunctsBuildStage == STAGE_INITIALIZING) attributes.add("toAssertGuaranteeConjuncts");
      return "Cannot build Tlsf, attribute initializers form cycle" + attributes;
    }
  }

  /**
   * @return The value of the {@code assert_} attribute
   */
  @Override
  public ImmutableList<Formula> assert_() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.assert_()
        : this.assert_;
  }

  /**
   * @return The value of the {@code assume} attribute
   */
  @Override
  public Formula assume() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.assume()
        : this.assume;
  }

  /**
   * @return The value of the {@code description} attribute
   */
  @Override
  public String description() {
    return description;
  }

  /**
   * @return The value of the {@code guarantee} attribute
   */
  @Override
  public ImmutableList<Formula> guarantee() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.guarantee()
        : this.guarantee;
  }

  /**
   * @return The value of the {@code initially} attribute
   */
  @Override
  public Formula initially() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.initially()
        : this.initially;
  }

  /**
   * @return The value of the {@code inputs} attribute
   */
  @Override
  public BitSet inputs() {
    return inputs;
  }

  /**
   * @return The value of the {@code outputs} attribute
   */
  @Override
  public BitSet outputs() {
    return outputs;
  }

  /**
   * @return The value of the {@code variables} attribute
   */
  @Override
  public ImmutableList<String> variables() {
    return variables;
  }

  /**
   * @return The value of the {@code preset} attribute
   */
  @Override
  public Formula preset() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.preset()
        : this.preset;
  }

  /**
   * @return The value of the {@code require} attribute
   */
  @Override
  public Formula require() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.require()
        : this.require;
  }

  /**
   * @return The value of the {@code semantics} attribute
   */
  @Override
  public Tlsf.Semantics semantics() {
    return semantics;
  }

  /**
   * @return The value of the {@code target} attribute
   */
  @Override
  public Tlsf.Semantics target() {
    return target;
  }

  /**
   * @return The value of the {@code title} attribute
   */
  @Override
  public String title() {
    return title;
  }

  /**
   * @return The computed-at-construction value of the {@code numberOfInputs} attribute
   */
  @Override
  public int numberOfInputs() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.numberOfInputs()
        : this.numberOfInputs;
  }

  /**
   * @return The computed-at-construction value of the {@code toFormula} attribute
   */
  @Override
  public LabelledFormula toFormula() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.toFormula()
        : this.toFormula;
  }

  /**
   * @return The computed-at-construction value of the {@code toAssertGuaranteeConjuncts} attribute
   */
  @Override
  public List<LabelledFormula> toAssertGuaranteeConjuncts() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.toAssertGuaranteeConjuncts()
        : this.toAssertGuaranteeConjuncts;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Tlsf#assert_() assert_}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTlsf withAssert_(Formula... elements) {
    ImmutableList<Formula> newValue = ImmutableList.copyOf(elements);
    return validate(new ImmutableTlsf(
        newValue,
        this.assume,
        this.description,
        this.guarantee,
        this.initially,
        this.inputs,
        this.outputs,
        this.variables,
        this.preset,
        this.require,
        this.semantics,
        this.target,
        this.title));
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Tlsf#assert_() assert_}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of assert_ elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTlsf withAssert_(Iterable<? extends Formula> elements) {
    if (this.assert_ == elements) return this;
    ImmutableList<Formula> newValue = ImmutableList.copyOf(elements);
    return validate(new ImmutableTlsf(
        newValue,
        this.assume,
        this.description,
        this.guarantee,
        this.initially,
        this.inputs,
        this.outputs,
        this.variables,
        this.preset,
        this.require,
        this.semantics,
        this.target,
        this.title));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Tlsf#assume() assume} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for assume
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTlsf withAssume(Formula value) {
    if (this.assume == value) return this;
    Formula newValue = Objects.requireNonNull(value, "assume");
    return validate(new ImmutableTlsf(
        this.assert_,
        newValue,
        this.description,
        this.guarantee,
        this.initially,
        this.inputs,
        this.outputs,
        this.variables,
        this.preset,
        this.require,
        this.semantics,
        this.target,
        this.title));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Tlsf#description() description} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for description
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTlsf withDescription(String value) {
    if (this.description.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "description");
    return validate(new ImmutableTlsf(
        this.assert_,
        this.assume,
        newValue,
        this.guarantee,
        this.initially,
        this.inputs,
        this.outputs,
        this.variables,
        this.preset,
        this.require,
        this.semantics,
        this.target,
        this.title));
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Tlsf#guarantee() guarantee}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTlsf withGuarantee(Formula... elements) {
    ImmutableList<Formula> newValue = ImmutableList.copyOf(elements);
    return validate(new ImmutableTlsf(
        this.assert_,
        this.assume,
        this.description,
        newValue,
        this.initially,
        this.inputs,
        this.outputs,
        this.variables,
        this.preset,
        this.require,
        this.semantics,
        this.target,
        this.title));
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Tlsf#guarantee() guarantee}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of guarantee elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTlsf withGuarantee(Iterable<? extends Formula> elements) {
    if (this.guarantee == elements) return this;
    ImmutableList<Formula> newValue = ImmutableList.copyOf(elements);
    return validate(new ImmutableTlsf(
        this.assert_,
        this.assume,
        this.description,
        newValue,
        this.initially,
        this.inputs,
        this.outputs,
        this.variables,
        this.preset,
        this.require,
        this.semantics,
        this.target,
        this.title));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Tlsf#initially() initially} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for initially
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTlsf withInitially(Formula value) {
    if (this.initially == value) return this;
    Formula newValue = Objects.requireNonNull(value, "initially");
    return validate(new ImmutableTlsf(
        this.assert_,
        this.assume,
        this.description,
        this.guarantee,
        newValue,
        this.inputs,
        this.outputs,
        this.variables,
        this.preset,
        this.require,
        this.semantics,
        this.target,
        this.title));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Tlsf#inputs() inputs} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for inputs
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTlsf withInputs(BitSet value) {
    if (this.inputs == value) return this;
    BitSet newValue = Objects.requireNonNull(value, "inputs");
    return validate(new ImmutableTlsf(
        this.assert_,
        this.assume,
        this.description,
        this.guarantee,
        this.initially,
        newValue,
        this.outputs,
        this.variables,
        this.preset,
        this.require,
        this.semantics,
        this.target,
        this.title));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Tlsf#outputs() outputs} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for outputs
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTlsf withOutputs(BitSet value) {
    if (this.outputs == value) return this;
    BitSet newValue = Objects.requireNonNull(value, "outputs");
    return validate(new ImmutableTlsf(
        this.assert_,
        this.assume,
        this.description,
        this.guarantee,
        this.initially,
        this.inputs,
        newValue,
        this.variables,
        this.preset,
        this.require,
        this.semantics,
        this.target,
        this.title));
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Tlsf#variables() variables}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTlsf withVariables(String... elements) {
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return validate(new ImmutableTlsf(
        this.assert_,
        this.assume,
        this.description,
        this.guarantee,
        this.initially,
        this.inputs,
        this.outputs,
        newValue,
        this.preset,
        this.require,
        this.semantics,
        this.target,
        this.title));
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Tlsf#variables() variables}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of variables elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTlsf withVariables(Iterable<String> elements) {
    if (this.variables == elements) return this;
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return validate(new ImmutableTlsf(
        this.assert_,
        this.assume,
        this.description,
        this.guarantee,
        this.initially,
        this.inputs,
        this.outputs,
        newValue,
        this.preset,
        this.require,
        this.semantics,
        this.target,
        this.title));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Tlsf#preset() preset} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for preset
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTlsf withPreset(Formula value) {
    if (this.preset == value) return this;
    Formula newValue = Objects.requireNonNull(value, "preset");
    return validate(new ImmutableTlsf(
        this.assert_,
        this.assume,
        this.description,
        this.guarantee,
        this.initially,
        this.inputs,
        this.outputs,
        this.variables,
        newValue,
        this.require,
        this.semantics,
        this.target,
        this.title));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Tlsf#require() require} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for require
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTlsf withRequire(Formula value) {
    if (this.require == value) return this;
    Formula newValue = Objects.requireNonNull(value, "require");
    return validate(new ImmutableTlsf(
        this.assert_,
        this.assume,
        this.description,
        this.guarantee,
        this.initially,
        this.inputs,
        this.outputs,
        this.variables,
        this.preset,
        newValue,
        this.semantics,
        this.target,
        this.title));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Tlsf#semantics() semantics} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for semantics
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTlsf withSemantics(Tlsf.Semantics value) {
    if (this.semantics == value) return this;
    Tlsf.Semantics newValue = Objects.requireNonNull(value, "semantics");
    return validate(new ImmutableTlsf(
        this.assert_,
        this.assume,
        this.description,
        this.guarantee,
        this.initially,
        this.inputs,
        this.outputs,
        this.variables,
        this.preset,
        this.require,
        newValue,
        this.target,
        this.title));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Tlsf#target() target} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for target
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTlsf withTarget(Tlsf.Semantics value) {
    if (this.target == value) return this;
    Tlsf.Semantics newValue = Objects.requireNonNull(value, "target");
    return validate(new ImmutableTlsf(
        this.assert_,
        this.assume,
        this.description,
        this.guarantee,
        this.initially,
        this.inputs,
        this.outputs,
        this.variables,
        this.preset,
        this.require,
        this.semantics,
        newValue,
        this.title));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Tlsf#title() title} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for title
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTlsf withTitle(String value) {
    if (this.title.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "title");
    return validate(new ImmutableTlsf(
        this.assert_,
        this.assume,
        this.description,
        this.guarantee,
        this.initially,
        this.inputs,
        this.outputs,
        this.variables,
        this.preset,
        this.require,
        this.semantics,
        this.target,
        newValue));
  }

  /**
   * This instance is equal to all instances of {@code ImmutableTlsf} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableTlsf
        && equalTo((ImmutableTlsf) another);
  }

  private boolean equalTo(ImmutableTlsf another) {
    return assert_.equals(another.assert_)
        && assume.equals(another.assume)
        && description.equals(another.description)
        && guarantee.equals(another.guarantee)
        && initially.equals(another.initially)
        && inputs.equals(another.inputs)
        && outputs.equals(another.outputs)
        && variables.equals(another.variables)
        && preset.equals(another.preset)
        && require.equals(another.require)
        && semantics.equals(another.semantics)
        && target.equals(another.target)
        && title.equals(another.title)
        && numberOfInputs == another.numberOfInputs
        && toFormula.equals(another.toFormula)
        && toAssertGuaranteeConjuncts.equals(another.toAssertGuaranteeConjuncts);
  }

  /**
   * Computes a hash code from attributes: {@code assert_}, {@code assume}, {@code description}, {@code guarantee}, {@code initially}, {@code inputs}, {@code outputs}, {@code variables}, {@code preset}, {@code require}, {@code semantics}, {@code target}, {@code title}, {@code numberOfInputs}, {@code toFormula}, {@code toAssertGuaranteeConjuncts}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + assert_.hashCode();
    h += (h << 5) + assume.hashCode();
    h += (h << 5) + description.hashCode();
    h += (h << 5) + guarantee.hashCode();
    h += (h << 5) + initially.hashCode();
    h += (h << 5) + inputs.hashCode();
    h += (h << 5) + outputs.hashCode();
    h += (h << 5) + variables.hashCode();
    h += (h << 5) + preset.hashCode();
    h += (h << 5) + require.hashCode();
    h += (h << 5) + semantics.hashCode();
    h += (h << 5) + target.hashCode();
    h += (h << 5) + title.hashCode();
    h += (h << 5) + numberOfInputs;
    h += (h << 5) + toFormula.hashCode();
    h += (h << 5) + toAssertGuaranteeConjuncts.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Tlsf} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Tlsf")
        .omitNullValues()
        .add("assert_", assert_)
        .add("assume", assume)
        .add("description", description)
        .add("guarantee", guarantee)
        .add("initially", initially)
        .add("inputs", inputs)
        .add("outputs", outputs)
        .add("variables", variables)
        .add("preset", preset)
        .add("require", require)
        .add("semantics", semantics)
        .add("target", target)
        .add("title", title)
        .add("numberOfInputs", numberOfInputs)
        .add("toFormula", toFormula)
        .add("toAssertGuaranteeConjuncts", toAssertGuaranteeConjuncts)
        .toString();
  }


  private static ImmutableTlsf validate(ImmutableTlsf instance) {
    instance.check();
    return instance;
  }

  /**
   * Creates an immutable copy of a {@link Tlsf} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Tlsf instance
   */
  public static ImmutableTlsf copyOf(Tlsf instance) {
    if (instance instanceof ImmutableTlsf) {
      return (ImmutableTlsf) instance;
    }
    return ImmutableTlsf.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableTlsf ImmutableTlsf}.
   * @return A new ImmutableTlsf builder
   */
  public static ImmutableTlsf.Builder builder() {
    return new ImmutableTlsf.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableTlsf ImmutableTlsf}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_DESCRIPTION = 0x1L;
    private static final long INIT_BIT_INPUTS = 0x2L;
    private static final long INIT_BIT_OUTPUTS = 0x4L;
    private static final long INIT_BIT_SEMANTICS = 0x8L;
    private static final long INIT_BIT_TARGET = 0x10L;
    private static final long INIT_BIT_TITLE = 0x20L;
    private static final long OPT_BIT_ASSERT_ = 0x1L;
    private static final long OPT_BIT_GUARANTEE = 0x2L;
    private long initBits = 0x3fL;
    private long optBits;

    private ImmutableList.Builder<Formula> assert_ = ImmutableList.builder();
    private @Nullable Formula assume;
    private @Nullable String description;
    private ImmutableList.Builder<Formula> guarantee = ImmutableList.builder();
    private @Nullable Formula initially;
    private @Nullable BitSet inputs;
    private @Nullable BitSet outputs;
    private ImmutableList.Builder<String> variables = ImmutableList.builder();
    private @Nullable Formula preset;
    private @Nullable Formula require;
    private @Nullable Tlsf.Semantics semantics;
    private @Nullable Tlsf.Semantics target;
    private @Nullable String title;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Tlsf} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Tlsf instance) {
      Objects.requireNonNull(instance, "instance");
      addAllAssert_(instance.assert_());
      assume(instance.assume());
      description(instance.description());
      addAllGuarantee(instance.guarantee());
      initially(instance.initially());
      inputs(instance.inputs());
      outputs(instance.outputs());
      addAllVariables(instance.variables());
      preset(instance.preset());
      require(instance.require());
      semantics(instance.semantics());
      target(instance.target());
      title(instance.title());
      return this;
    }

    /**
     * Adds one element to {@link Tlsf#assert_() assert_} list.
     * @param element A assert_ element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAssert_(Formula element) {
      this.assert_.add(element);
      optBits |= OPT_BIT_ASSERT_;
      return this;
    }

    /**
     * Adds elements to {@link Tlsf#assert_() assert_} list.
     * @param elements An array of assert_ elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAssert_(Formula... elements) {
      this.assert_.add(elements);
      optBits |= OPT_BIT_ASSERT_;
      return this;
    }

    /**
     * Sets or replaces all elements for {@link Tlsf#assert_() assert_} list.
     * @param elements An iterable of assert_ elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder assert_(Iterable<? extends Formula> elements) {
      this.assert_ = ImmutableList.builder();
      return addAllAssert_(elements);
    }

    /**
     * Adds elements to {@link Tlsf#assert_() assert_} list.
     * @param elements An iterable of assert_ elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllAssert_(Iterable<? extends Formula> elements) {
      this.assert_.addAll(elements);
      optBits |= OPT_BIT_ASSERT_;
      return this;
    }

    /**
     * Initializes the value for the {@link Tlsf#assume() assume} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link Tlsf#assume() assume}.</em>
     * @param assume The value for assume 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder assume(Formula assume) {
      this.assume = Objects.requireNonNull(assume, "assume");
      return this;
    }

    /**
     * Initializes the value for the {@link Tlsf#description() description} attribute.
     * @param description The value for description 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder description(String description) {
      this.description = Objects.requireNonNull(description, "description");
      initBits &= ~INIT_BIT_DESCRIPTION;
      return this;
    }

    /**
     * Adds one element to {@link Tlsf#guarantee() guarantee} list.
     * @param element A guarantee element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addGuarantee(Formula element) {
      this.guarantee.add(element);
      optBits |= OPT_BIT_GUARANTEE;
      return this;
    }

    /**
     * Adds elements to {@link Tlsf#guarantee() guarantee} list.
     * @param elements An array of guarantee elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addGuarantee(Formula... elements) {
      this.guarantee.add(elements);
      optBits |= OPT_BIT_GUARANTEE;
      return this;
    }

    /**
     * Sets or replaces all elements for {@link Tlsf#guarantee() guarantee} list.
     * @param elements An iterable of guarantee elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder guarantee(Iterable<? extends Formula> elements) {
      this.guarantee = ImmutableList.builder();
      return addAllGuarantee(elements);
    }

    /**
     * Adds elements to {@link Tlsf#guarantee() guarantee} list.
     * @param elements An iterable of guarantee elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllGuarantee(Iterable<? extends Formula> elements) {
      this.guarantee.addAll(elements);
      optBits |= OPT_BIT_GUARANTEE;
      return this;
    }

    /**
     * Initializes the value for the {@link Tlsf#initially() initially} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link Tlsf#initially() initially}.</em>
     * @param initially The value for initially 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder initially(Formula initially) {
      this.initially = Objects.requireNonNull(initially, "initially");
      return this;
    }

    /**
     * Initializes the value for the {@link Tlsf#inputs() inputs} attribute.
     * @param inputs The value for inputs 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder inputs(BitSet inputs) {
      this.inputs = Objects.requireNonNull(inputs, "inputs");
      initBits &= ~INIT_BIT_INPUTS;
      return this;
    }

    /**
     * Initializes the value for the {@link Tlsf#outputs() outputs} attribute.
     * @param outputs The value for outputs 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder outputs(BitSet outputs) {
      this.outputs = Objects.requireNonNull(outputs, "outputs");
      initBits &= ~INIT_BIT_OUTPUTS;
      return this;
    }

    /**
     * Adds one element to {@link Tlsf#variables() variables} list.
     * @param element A variables element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addVariables(String element) {
      this.variables.add(element);
      return this;
    }

    /**
     * Adds elements to {@link Tlsf#variables() variables} list.
     * @param elements An array of variables elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addVariables(String... elements) {
      this.variables.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link Tlsf#variables() variables} list.
     * @param elements An iterable of variables elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder variables(Iterable<String> elements) {
      this.variables = ImmutableList.builder();
      return addAllVariables(elements);
    }

    /**
     * Adds elements to {@link Tlsf#variables() variables} list.
     * @param elements An iterable of variables elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllVariables(Iterable<String> elements) {
      this.variables.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link Tlsf#preset() preset} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link Tlsf#preset() preset}.</em>
     * @param preset The value for preset 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder preset(Formula preset) {
      this.preset = Objects.requireNonNull(preset, "preset");
      return this;
    }

    /**
     * Initializes the value for the {@link Tlsf#require() require} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link Tlsf#require() require}.</em>
     * @param require The value for require 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder require(Formula require) {
      this.require = Objects.requireNonNull(require, "require");
      return this;
    }

    /**
     * Initializes the value for the {@link Tlsf#semantics() semantics} attribute.
     * @param semantics The value for semantics 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder semantics(Tlsf.Semantics semantics) {
      this.semantics = Objects.requireNonNull(semantics, "semantics");
      initBits &= ~INIT_BIT_SEMANTICS;
      return this;
    }

    /**
     * Initializes the value for the {@link Tlsf#target() target} attribute.
     * @param target The value for target 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder target(Tlsf.Semantics target) {
      this.target = Objects.requireNonNull(target, "target");
      initBits &= ~INIT_BIT_TARGET;
      return this;
    }

    /**
     * Initializes the value for the {@link Tlsf#title() title} attribute.
     * @param title The value for title 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder title(String title) {
      this.title = Objects.requireNonNull(title, "title");
      initBits &= ~INIT_BIT_TITLE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableTlsf ImmutableTlsf}.
     * @return An immutable instance of Tlsf
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableTlsf build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return ImmutableTlsf.validate(new ImmutableTlsf(this));
    }

    private boolean assert_IsSet() {
      return (optBits & OPT_BIT_ASSERT_) != 0;
    }

    private boolean guaranteeIsSet() {
      return (optBits & OPT_BIT_GUARANTEE) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_DESCRIPTION) != 0) attributes.add("description");
      if ((initBits & INIT_BIT_INPUTS) != 0) attributes.add("inputs");
      if ((initBits & INIT_BIT_OUTPUTS) != 0) attributes.add("outputs");
      if ((initBits & INIT_BIT_SEMANTICS) != 0) attributes.add("semantics");
      if ((initBits & INIT_BIT_TARGET) != 0) attributes.add("target");
      if ((initBits & INIT_BIT_TITLE) != 0) attributes.add("title");
      return "Cannot build Tlsf, some of required attributes are not set " + attributes;
    }
  }
}
