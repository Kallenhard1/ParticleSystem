ParticleSystem ps;

void setup() {
  size(600, 400);
  //Now its time to control the position through the mouse.
  ps = new ParticleSystem(new PVector(width/2, 50));
}

void draw() {
  background(220);
  
  PVector gravity = new PVector(0, 0.5);
  ps.applyForce(gravity);
  
  if(mousePressed) {
    PVector wind = new PVector(0.2, 0);
    ps.applyForce(wind);
  }
  
  ps.addParticle();
  ps.run();
 
  


//saveFrame("particles_####.png");
}
