class Particle {
PVector position;
PVector velocity;
PVector acceleration;
float r = 12;
float lifespan;

Particle(PVector l) {
  acceleration = new PVector(0, 0.5);
  velocity = new PVector(random(-1, 1), random(-2, 0));
  position = l.get();
  lifespan = 255.0;
}

void applyForce(PVector force){
  acceleration.add(force);
}

void run() {
  update();
  display();
}

void update() {
  velocity.add(acceleration);
  position.add(velocity);
  acceleration.mult(0);
  lifespan -= 2.0;
}

void display(){
  stroke(0, lifespan);
  strokeWeight(2);
  fill(127, lifespan);
  ellipse(position.x, position.y, r, r);
}

boolean isDead() {
  if (lifespan < 0.0){
    return true;
  } else {
  return false;
  }
}

}
