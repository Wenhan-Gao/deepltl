import preprocessing  # Ensure preprocessing is loaded first
import model.ltl.ltl_net  # Load LTLNet before any other imports
import config  # Load config before it's used elsewhere

from visualize.automata import draw_ldba, construct_ldba

import re

def to_valid_win_filename(text):
    # Replace '->' with '_to_'
    text = text.replace("->", "_to_")
    
    # Replace spaces with underscores
    text = text.replace(" ", "_")

    text = text.replace("|", "OR")
    
    # Remove invalid characters (extra safety)
    text = re.sub(r'[<>:"/\\|?*]', "", text)
    
    return text




props = {'red', 'magenta', 'blue', 'green', 'aqua', 'yellow', 'orange'}
# f = 'F blue'
f = 'G F blue -> G F green'
# f = 'G F (green & F blue)'
# f = 'G F green & G F blue'
# f = 'G F blue & G F green & G F yellow & G !magenta'
# f = ' ((green | blue) -> (!yellow U magenta)) U yellow' 
# f = '!green U ((blue | magenta) & (!green U yellow))'
# f = '!green U (blue | magenta)'
# f = 'G F blue'
# f = '!green U (blue & (magenta U yellow))' # Failed
# f = '!(magenta | yellow) U (blue & F green)'
# f = 'F (blue | green) & F yellow & F magenta'
# f = 'F blue & (!blue U (green & F yellow))'
# f = ' F (green & (!blue U yellow)) & F magenta'
# f = '(F G green) | F blue'
# f = 'yellow | X G (green | F blue)'
# f = 'green & X (F G green | F G blue)'
# f = 'F green & X (F G green | F G blue)'
# f = '(G(F(blue)) & (G((blue -> (F((!blue) U green))) & (green -> (F((!green) U blue))))))'
# f = '(F blue -> F magenta) | (F green -> F yellow)'
# f = 'F(blue & F(magenta)) | F(green & F(yellow))'
f = 'F green & X (F G yellow | F G blue)'
# f = '(F green & X (F G yellow | F G blue)) | (F yellow & X (F G green | F G magenta))'
# f = 'F G blue & F (yellow & F green)'
# f = 'F ( blue & ( F green & ( F yellow & ( F magenta))))'
# f = 'F ( blue & F (green & F (yellow & F magenta)))'
# f = '(G F blue) & (G F blue -> G F green)'
# f = '(G F blue) & (G F blue -> G F green) | (G F magenta) & (G F magenta -> G F yellow)'
# f = '(G F blue) & ((G F blue -> G F green) & (G F green -> G F yellow)) | (G F magenta) & (G F magenta -> G F yellow)'
# f = 'G ((green| yellow) -> F blue) & F G (green | magenta)'
# f = 'F magenta & X F G (green | blue | yellow)'
# f = '(G F blue) & (F blue -> G F green)'
# f = '(G F green) | (G F magenta)'
# f = '(G F blue & G F green) | (F G yellow)'
# f = 'F green & X (G F blue | G F yellow)'
# f = 'G ((green | yellow) -> F blue) & F G (green | magenta)'
# f = '(F G green & G !yellow) | (F G yellow & G !magenta) | (F G magenta & G !blue) | (F G blue & G !green)'
f = 'F green & F X blue & F X green & F X blue & F X green & F X blue & F X green'
f =  'F (green & F (blue & F (green & F (blue & F (green & F (blue & F (green & F blue)))))))'
f = 'G F yellow & G F green & G F blue & G !magenta'

filename = to_valid_win_filename(f)
print("filename",filename)
ldba = construct_ldba(f, simplify_labels=False, prune=True, ldba=True)
# print(f'Finite: {ldba.is_finite_specification()}')
draw_ldba(ldba, filename=filename, fmt='png', positive_label=True, self_loops=True)
from sequence.search import ExhaustiveSearch
search = ExhaustiveSearch(None, props, num_loops=1)
seqs = search.all_sequences(ldba, ldba.initial_state)
print(seqs)
print(len(seqs))
print()
print(ldba)