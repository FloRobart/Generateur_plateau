public class PanelDefilement extends JPanel {

    private JComponent component;
    private int width = 300;

    public PanelDefilement(JComponent component) {
        
        setLayout(new BorderLayout());

        this.component = component;

        add(this.component, BorderLayout.CENTER);
        add(new BarreDefilement(), BorderLayout.WEST);

        // TODO : ajouter un curseur
    }

    @Override
    public Dimension getPreferredSize() {
        
        return new Dimension(width + 20, component.getPreferredSize().height);
    }

    private class BarreDefilement extends JPanel {

        private final MouseAdapter MOUSE_ADAPTER = new MouseAdapter() {
        
            private Point origin;
    
            @Override
            public void mousePressed(MouseEvent e) {
                
                origin = new Point(e.getPoint());
            }
    
            @Override
            public void mouseDragged(MouseEvent e) {
                
                if (origin != null) {
                    
                    int deltaX = origin.x - e.getX();
                    width += deltaX;
                    PanelDefilement.this.revalidate();
                }
            }
        };

        public BarreDefilement() {
            
            setLayout(null);

            addMouseListener(MOUSE_ADAPTER);
            addMouseMotionListener(MOUSE_ADAPTER);
        }

        @Override
        public Dimension getPreferredSize() {
            
            return new Dimension(20, super.getPreferredSize().height);
        }

        @Override
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            
            g.setColor(Color.RED);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
