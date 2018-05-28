import numpy as np

# data I/O
data = """

Aardvark	Orycteropus afer
Aardwolf	Proteles cristata
African bush elephant	Loxodonta africana
Amazon river dolphin	Inia geoffrensis
American alligator	Alligator mississippiensis
American bison	Bison bison
American crow	Corvus brachyrhynchos
American flamingo	Phoenicopterus ruber
American white pelican	Pelecanus erythrorhynchos
Andean condor	Vultur gryphus
Arabian camel	Camelus dromedarius
Asian elephant	Elephas maximus
Atlantic salmon	Salmo salar
Bahaman raccoon	Procyon lotor maynardi
Bald eagle	Haliaeetus leucocephalus
Banded pitviper	Trimeresurus fasciatus
Bee hummingbird	Mellisuga helenae
Black rhinoceros	Diceros bicornis
Black widow spider	Latrodectus mactans
Black wildebeest	Connochaetes gnou
Blue whale	Balaenoptera musculus
Bobcat	Lynx rufus
California condor	Gymnogyps californianus
California sea lion	Zalophus californianus
Capybara	Hydrochoerus hydrochaeris
Caribou/reindeer	Rangifer tarandus
Cheetah	Acinonyx jubatus
Common bottlenose dolphin	Tursiops truncatus
Common chimpanzee	Pan troglodytes
Cougar	Puma concolor
Coyote	Canis latrans
Dingo	Canis dingo
Eastern diamondback rattlesnake	Crotalus adamanteus
Elephant seal	Mirounga angustirostris
Elk	Cervus canadensis
Emperor penguin	Aptenodytes forsteri
Emu	Dromaius novaehollandiae
European otter	Lutra lutra
Four-horned antelope	Tetracerus quadricornis
Giant anteater	Myrmecophaga tridactyla
Giant panda	Ailuropoda melanoleuca
Giraffe	Giraffa camelopardalis
Golden hamster	Mesocricetus auratus
Golden-capped fruit bat	Acerodon jubatus
Gray fox	Urocyon cinereoargenteus
Wolf	Canis lupus
Great spotted kiwi	Apteryx haastii
Great white shark	Carcharodon carcharias
Greater dwarf lemur	Cheirogaleus major
Green anaconda	Eunectes murinus
Gray heron	Ardea cinerea
Gray squirrel	Sciurus carolinensis
Guinea baboon	Papio papio
Guinea pig	Cavia cobaya
Hedgehog	Erinaceus europeaeus
Hippopotamus	Hippopotamus amphibius
Horse	Equus caballus
Iguana	Iguana iguana
Impala	Aepyceros melampus
Jackal	Canis aureus
Jaguar	Panthera onca
Kangaroo rat	Dipodomys phillipsii
Killer whale	Orcinus orca
King cobra	Ophiophagus hannah
Koala bear	Phascolarctos cinereus
Komodo dragon	Varanus komodoensis
Leatherback turtle	Dermochelys coriacea
Leopard	Panthera pardus
Lion	Panthera leo
Marsh rabbit	Sylvilagus palustris
Mekong giant catfish	Pangasianodon gigas
Nightingale	Luscinia megarhynchos
Nine-banded armadillo	Dasypus novemcinctus
North American beaver	Castor canadensis
Northern cardinal	Cardinalis cardinalis
Northern flying squirrel	Glaucomys sabrinus
Ocelot	Felis pardalis
Orangutan	Pongo pygmaeus
Ostrich	Struthio camelus
Peregrine falcon	Falco peregrinus
Polar bear	Ursus maritimus
Praying mantis	Mantis religioso
Red kangaroo	Macropus rufus
Red panda	Ailurus fulgens
Snow leopard	Panthera uncia
Snowy owl	Bubo scandiacus
Sparrow	Prunella modularis
Sperm whale	Physeter catodon
Spider monkey	Ateles geoffroyi
Spotted halibut	Verasper variegatus
Spotted hyena	Crocuta crocuta
Spur-thighed tortoise	Testudo graeca
Tarantula	Lycosa tarentula
Tasmanian devil	Sarcophilus hariisi
Tiger	Panthera tigris
Tiger shark	Galeocerdo cuvieri
Turkey	Meleagris gallopavo
Virginia opossum	Didelphis virginiana
Western gorilla	Gorilla gorilla
White-backed vulture	Gyps africanus
Wildcat	Felis silvestris
Wolverine	Gulo gulo
"""
#open('input.txt', 'r').read() # should be simple plain text file
chars = list(set(data))
data_size, vocab_size = len(data), len(chars)
print 'data has %d characters, %d unique.' % (data_size, vocab_size)
char_to_ix = { ch:i for i,ch in enumerate(chars) }
ix_to_char = { i:ch for i,ch in enumerate(chars) }

# hyperparameters
hidden_size = 100 # size of hidden layer of neurons
seq_length = 25 # number of steps to unroll the RNN for
learning_rate = 1e-1

# model parameters
Wxh = np.random.randn(hidden_size, vocab_size)*0.01 # input to hidden
Whh = np.random.randn(hidden_size, hidden_size)*0.01 # hidden to hidden
Why = np.random.randn(vocab_size, hidden_size)*0.01 # hidden to output
bh = np.zeros((hidden_size, 1)) # hidden bias
by = np.zeros((vocab_size, 1)) # output bias

def lossFun(inputs, targets, hprev):
  """
  inputs,targets are both list of integers.
  hprev is Hx1 array of initial hidden state
  returns the loss, gradients on model parameters, and last hidden state
  """
  xs, hs, ys, ps = {}, {}, {}, {}
  hs[-1] = np.copy(hprev)
  loss = 0
  # forward pass
  for t in xrange(len(inputs)):
    xs[t] = np.zeros((vocab_size,1)) # encode in 1-of-k representation
    xs[t][inputs[t]] = 1
    hs[t] = np.tanh(np.dot(Wxh, xs[t]) + np.dot(Whh, hs[t-1]) + bh) # hidden state
    ys[t] = np.dot(Why, hs[t]) + by # unnormalized log probabilities for next chars
    ps[t] = np.exp(ys[t]) / np.sum(np.exp(ys[t])) # probabilities for next chars
    loss += -np.log(ps[t][targets[t],0]) # softmax (cross-entropy loss)
  # backward pass: compute gradients going backwards
  dWxh, dWhh, dWhy = np.zeros_like(Wxh), np.zeros_like(Whh), np.zeros_like(Why)
  dbh, dby = np.zeros_like(bh), np.zeros_like(by)
  dhnext = np.zeros_like(hs[0])
  for t in reversed(xrange(len(inputs))):
    dy = np.copy(ps[t])
    dy[targets[t]] -= 1 # backprop into y. see http://cs231n.github.io/neural-networks-case-study/#grad if confused here
    dWhy += np.dot(dy, hs[t].T)
    dby += dy
    dh = np.dot(Why.T, dy) + dhnext # backprop into h
    dhraw = (1 - hs[t] * hs[t]) * dh # backprop through tanh nonlinearity
    dbh += dhraw
    dWxh += np.dot(dhraw, xs[t].T)
    dWhh += np.dot(dhraw, hs[t-1].T)
    dhnext = np.dot(Whh.T, dhraw)
  for dparam in [dWxh, dWhh, dWhy, dbh, dby]:
    np.clip(dparam, -5, 5, out=dparam) # clip to mitigate exploding gradients
  return loss, dWxh, dWhh, dWhy, dbh, dby, hs[len(inputs)-1]

def sample(h, seed_ix, n):
  """ 
  sample a sequence of integers from the model 
  h is memory state, seed_ix is seed letter for first time step
  """
  x = np.zeros((vocab_size, 1))
  x[seed_ix] = 1
  ixes = []
  for t in xrange(n):
    h = np.tanh(np.dot(Wxh, x) + np.dot(Whh, h) + bh)
    y = np.dot(Why, h) + by
    p = np.exp(y) / np.sum(np.exp(y))
    ix = np.random.choice(range(vocab_size), p=p.ravel())
    x = np.zeros((vocab_size, 1))
    x[ix] = 1
    ixes.append(ix)
  return ixes

n, p = 0, 0
mWxh, mWhh, mWhy = np.zeros_like(Wxh), np.zeros_like(Whh), np.zeros_like(Why)
mbh, mby = np.zeros_like(bh), np.zeros_like(by) # memory variables for Adagrad
smooth_loss = -np.log(1.0/vocab_size)*seq_length # loss at iteration 0
while True:
  # prepare inputs (we're sweeping from left to right in steps seq_length long)
  if p+seq_length+1 >= len(data) or n == 0: 
    hprev = np.zeros((hidden_size,1)) # reset RNN memory
    p = 0 # go from start of data
  inputs = [char_to_ix[ch] for ch in data[p:p+seq_length]]
  targets = [char_to_ix[ch] for ch in data[p+1:p+seq_length+1]]

  # sample from the model now and then
  if n % 100 == 0:
    sample_ix = sample(hprev, inputs[0], 200)
    txt = ''.join(ix_to_char[ix] for ix in sample_ix)
    print '----\n %s \n----' % (txt, )

  # forward seq_length characters through the net and fetch gradient
  loss, dWxh, dWhh, dWhy, dbh, dby, hprev = lossFun(inputs, targets, hprev)
  smooth_loss = smooth_loss * 0.999 + loss * 0.001
  if n % 100 == 0: print 'iter %d, loss: %f' % (n, smooth_loss) # print progress
  
  # perform parameter update with Adagrad
  for param, dparam, mem in zip([Wxh, Whh, Why, bh, by], 
                                [dWxh, dWhh, dWhy, dbh, dby], 
                                [mWxh, mWhh, mWhy, mbh, mby]):
    mem += dparam * dparam
    param += -learning_rate * dparam / np.sqrt(mem + 1e-8) # adagrad update

  p += seq_length # move data pointer
  n += 1 # iteration counter 
