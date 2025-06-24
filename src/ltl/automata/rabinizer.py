import subprocess

RABINIZER_PATH = 'rabinizer4/bin/ltl2ldba'

RABINIZER_JAR = 'rabinizer4\lib\owl.jar'

def run_rabinizer(formula: str) -> str:
    """Convert an LTL formula to a LDBA in the HOA format."""
    # -p: parallel processing
    # -d: construct a non-generalised Buechi automaton
    # -e: keep generated epsilon transitions
    # command = [RABINIZER_PATH, '-i', formula, '-p', '-d', '-e']
    command = [
        "java",
        "-classpath",
        RABINIZER_JAR,
        "owl.translations.ltl2ldba.LTL2LDBACliParser",
        "-i",
        formula,
        "-p",
        "-d",
        "-e"
    ]    
    print(f"Running command: {' '.join(command)}")
    run = subprocess.run(command, capture_output=True, text=True)
    if run.stderr != '':
        raise RuntimeError(f'Rabinizer call `{" ".join(command)}` resulted in an error.\nError: {run.stderr}.')
    return run.stdout


if __name__ == '__main__':
    f = 'FG a'
    ldba = run_rabinizer(f)
    print(ldba)
