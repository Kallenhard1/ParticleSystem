ArrayList<Particle> particles;

void setup() {
  size(600, 400);
  particles = new ArrayList<Particle>();
}

void draw() {
  background(220);
  
  particles.add(new SquareParticle(new PVector(width/2, height/4)));
  
  for(int i = particles.size()-1; i>=0; i--) {
    Particle p = particles.get(i);
    p.update();
    p.display();
    if(p.isDead()) {
      particles.remove(i);
    }
  }


}

//Particle Class
class Particle {
  //I'm tryng to add an angular momentum to this class.
  float a = PI/4;
  float g = 0.1;
  PVector position;
  PVector velocity;
  PVector acceleration;
  float r = 12;
  float lifespan;

  Particle(PVector l) {
    position = new PVector(r*cos(a), r*sin(a));
    acceleration = new PVector(0, 0.05);
    velocity = new PVector(random(-1, 1), random(-2, 0));
    position = l.copy();
    lifespan = 255.0;
  }

  void run() {
    update();
    display();
  }

  // Method to update position
  void update() {
    velocity.add(acceleration);
    position.add(velocity);
    a = a + position.y;
    lifespan -= 1.0;
  }

  // Method to display
  void display() {
    stroke(0, lifespan);
    strokeWeight(2);
    fill(127, lifespan);
    ellipse(position.x, position.y, r, r);
  }

  // Is the particle still useful?
  boolean isDead() {
    if (lifespan < 0.0) {
      return true;
    } 
    else {
      return false;
    }
  }
}

//Square Particle Class
class SquareParticle extends Particle {
  SquareParticle(PVector l){
    super(l);
  }
  void display() {
    fill(127, lifespan);
    stroke(2, lifespan);
    rect(position.x, position.y, r, r);
  }

}
