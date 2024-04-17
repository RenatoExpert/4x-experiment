use warnings;
use strict;

my $deps_file = './deps.txt';
sub get_links {
	open(IC, '<', $deps_file) or die($!);
	while(<IC>) {
		if( $_ =~ /(https**.jar)/i ) {
			return $_;
		}
	}
	close(IC);
}

sub write_list {
	my $output_file = 'links.txt';
	open(OF, '>>', $output_file);
	print OF $_[0] or die($!);
	close(OF);
}

my $links = get_links();
write_list($links);

